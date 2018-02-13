package beans;

import java.io.Serializable;

public class Bebida extends Item implements Serializable{

	private String nome;
	private String tamanho;
	
	public Bebida(int id, double valor, String nome, String tamanho){
		super(id);
		super.setValor(valor);
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
}
