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
	}
	
	public void removerPedido(Pedido e) {
		listaDePedidos.remove(e);
	}
	
	public ArrayList<Pedido> getListaDePedidos(){
		return listaDePedidos;
	}
}
