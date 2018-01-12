package beans;

import java.util.ArrayList;

public class Mesa {
	int id;
	ArrayList<Pedido> pedidos;
	
	public Mesa(int id){
		pedidos = new ArrayList<Pedido>();
		this.id = id;
	}
}
