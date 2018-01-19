package gerenciamento;

import java.util.ArrayList;

import beans.Bebida;
import beans.Item;
import beans.Pedido;
import interfaces.IRepositorioPedidos;
import repositorios.RepositorioPedidos;

public class GerenciamentoPedidos {
	private IRepositorioPedidos pedidos = RepositorioPedidos.getInstance();
	
	public void cadastrarPedido(Pedido a) {
		if (a != null){
			pedidos.adicionarPedido(a);
		}
	}

	public void removerPedido(Pedido a) {
		if (a != null) {
			pedidos.removerPedido(a);
		}
	}
	
	public ArrayList<Pedido> listarPedido(){
		return pedidos.getListaDePedidos();
	}
	
}
