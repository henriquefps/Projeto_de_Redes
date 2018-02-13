package beans;

import java.io.Serializable;

public class Funcionario implements Serializable{
	private String cpf;
	private int id;
	
	public Funcionario(String cpf, int id){
		this.cpf = cpf;
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
