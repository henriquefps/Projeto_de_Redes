package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Mesa implements Serializable{
	private int id;
	private ArrayList<Pedido> pedidos;
	
	public Mesa(int id){
		pedidos = new ArrayList<Pedido>();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}

