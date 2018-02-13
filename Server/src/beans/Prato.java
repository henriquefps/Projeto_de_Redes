package beans;

import java.io.Serializable;

public class Prato extends Item implements Serializable{

	private String nome;
	private String descricao;
	private int serveNPessoas;
	private boolean pronto;
	
	public Prato(int id, double valor, String nome, String descricao, int serveNPessoas){
		super(id);
		super.setValor(valor);
		this.nome = nome;
		this.descricao = descricao;
		this.serveNPessoas = serveNPessoas;
		this.pronto = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getServeNPessoas() {
		return serveNPessoas;
	}

	public void setServeNPessoas(int serveNPessoas) {
		this.serveNPessoas = serveNPessoas;
	}

	public boolean isPronto() {
		return pronto;
	}

	public void setPronto(boolean pronto) {
		this.pronto = pronto;
	}
	
	
}
