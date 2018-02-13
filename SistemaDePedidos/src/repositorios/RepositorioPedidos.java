package repositorios;

import java.util.ArrayList;

import beans.Pedido;
import interfaces.IRepositorioFuncionarios;
import interfaces.IRepositorioPedidos;

public class RepositorioPedidos implements IRepositorioPedidos {
	
	private static RepositorioPedidos instance;
	private ArrayList<Pedido> listaDePedidos;
	
	private RepositorioPedidos() {
		listaDePedidos = new ArrayList<Pedido>();
	}
	
	public static RepositorioPedidos getInstance() {
		if(instance == null) {
			instance = new RepositorioPedidos();
		}
		return instance;
	}
	
	public void adicionarPedido(Pedido e) {
		listaDePedidos.add(e);
		Repositorio_Servidor.atualizarListas(false);
	}
	
	public void removerPedido(Pedido e) {
		listaDePedidos.remove(e);
		Repositorio_Servidor.atualizarListas(false);
	}
	
	public ArrayList<Pedido> getListaDePedidos(){
		return listaDePedidos;
	}

	/**
	 * @param listaDePedidos the listaDePedidos to set
	 */
	public void setListaDePedidos(ArrayList<Pedido> listaDePedidos) {
		this.listaDePedidos = listaDePedidos;
	}
	
}
