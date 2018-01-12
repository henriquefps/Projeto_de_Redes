package interfaces;

import java.util.ArrayList;

import beans.Pedido;

public interface IRepositorioPedidos {

	public abstract void adicionarPedido(Pedido e);
	public abstract void removerPedido(Pedido e);
	public abstract ArrayList<Pedido> getListaDePedidos();
}
