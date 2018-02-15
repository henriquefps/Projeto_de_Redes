package repositorios;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import beans.Funcionario;
import beans.Item;
import beans.Mesa;
import beans.NaoEscrever;
import beans.Pedido;

public class Repositorio_Servidor {
	private static RepositorioFuncionarios funcionarios = RepositorioFuncionarios.getInstance();
	private static RepositorioItens itens = RepositorioItens.getInstance();
	private static RepositorioMesas mesas = RepositorioMesas.getInstance();
	private static RepositorioPedidos pedidos = RepositorioPedidos.getInstance();

	@SuppressWarnings({ "resource", "unchecked" })
	public static void atualizarListas(boolean isInicioDoPrograma) {
		try {
			Object listas[] = new Object[4];
			listas[0] = funcionarios.getListaDeFuncionarios();
			listas[1] = itens.getListaDeItens();
			listas[2] = mesas.getListaDeMesas();
			listas[3] = pedidos.getListaDePedidos();

			Socket cliente = new Socket("172.16.207.89", 12345);

			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

			saida.writeObject(listas);
			listas = (Object[]) entrada.readObject();
			System.err.println("oi");

			funcionarios.setListaDeFuncionarios((ArrayList<Funcionario>) listas[0]);
			itens.setListaDeItens((ArrayList<Item>) listas[1]);
			mesas.setListaDeMesas((ArrayList<Mesa>) listas[2]);
			pedidos.setListaDePedidos((ArrayList<Pedido>) listas[3]);

			System.out.println(funcionarios.getListaDeFuncionarios().size());

			entrada.close();
			System.out.println("Conexão encerrada");
		} catch (Exception e) {
			System.err.println("Erro cliente: " + e.getMessage());
			System.exit(0);
		}
	}
}
