package beans;

import java.io.Serializable;

public class Cozinheiro extends Funcionario implements Serializable{
	public Cozinheiro(String cpf, int id){
		super(cpf, id);
	}
}
