package beans;

import java.util.ArrayList;

public class Pedido{
	private Boolean pronto;
	private int id;
	private ArrayList<Item> itens;
	private double valor;
	private int idMesa;
	
	public Pedido(int id, int idMesa){
		itens = new ArrayList<Item>();
		this.id = id;
		this.idMesa = idMesa;
	}

	public Boolean getPronto() {
		return pronto;
	}

	public void setPronto(Boolean pronto) {
		this.pronto = pronto;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	
	
}
