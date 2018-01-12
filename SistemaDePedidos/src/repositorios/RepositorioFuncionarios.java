package repositorios;

import java.util.ArrayList;

import beans.Funcionario;
import interfaces.IRepositorioFuncionarios;

public class RepositorioFuncionarios implements IRepositorioFuncionarios{
	
	private static RepositorioFuncionarios instance;
	private ArrayList<Funcionario> listaDeFuncionarios;
	
	private RepositorioFuncionarios() {
		listaDeFuncionarios = new ArrayList<Funcionario>();
	}
	
	public static RepositorioFuncionarios getInstance() {
		if(instance == null) {
			instance = new RepositorioFuncionarios();
		}
		return instance;
	}
	
	public void adicionarFuncionario(Funcionario e) {
		listaDeFuncionarios.add(e);
	}
	
	public void removerFuncionario(Funcionario e) {
		listaDeFuncionarios.remove(e);
	}
	
	public ArrayList<Funcionario> getListaDeFuncionarios(){
		return listaDeFuncionarios;
	}
}
