package beans;

public class Item {
	private int id;
	private double valor;
	
	public Item(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
