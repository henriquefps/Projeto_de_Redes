package gerenciamento;

import java.util.ArrayList;

import beans.Cozinheiro;
import beans.Funcionario;
import beans.Garcom;
import interfaces.IRepositorioFuncionarios;
import repositorios.RepositorioFuncionarios;

public class GerenciamentoFuncionarios {
	private IRepositorioFuncionarios funcionarios = RepositorioFuncionarios.getInstance();

	public void cadastrarGarcom(Garcom a) {
		if (a != null && !existe(a)) {
			funcionarios.adicionarFuncionario(a);
		}
	}

	public void cadastrarCozinheiro(Cozinheiro a) {
		if (a != null && !existe(a)) {
			funcionarios.adicionarFuncionario(a);
		}
	}

	public boolean existe(Funcionario a) {
		for (int i = 0; i < funcionarios.getListaDeFuncionarios().size(); i++) {
			if (funcionarios.getListaDeFuncionarios().get(i).getCpf().equals(a.getCpf())) {
				return true;
			}
		}
		return false;
	}

	public void removerFuncionario(Funcionario a) {
		if (a != null) {
			funcionarios.removerFuncionario(a);
		}
	}
	
	public ArrayList<Funcionario> listarFuncionarios(){
		return funcionarios.getListaDeFuncionarios();
	}
	
	public ArrayList<Garcom> listarGarcons(){
		ArrayList<Garcom> aux = new ArrayList<Garcom>();
		for (int i = 0; i < listarFuncionarios().size(); i++) {
			if(listarFuncionarios().get(i) instanceof Garcom){
				aux.add((Garcom) listarFuncionarios().get(i));
			}
		}
		return aux;
	}
	
	public ArrayList<Cozinheiro> listarCozinheiros(){
		ArrayList<Cozinheiro> aux = new ArrayList<Cozinheiro>();
		for (int i = 0; i < listarFuncionarios().size(); i++) {
			if(listarFuncionarios().get(i) instanceof Cozinheiro){
				aux.add((Cozinheiro) listarFuncionarios().get(i));
			}
		}
		return aux;
	}
	
	public Funcionario buscarFuncionario(String cpf){
		Funcionario aux = null;
		for (int i = 0; i < listarFuncionarios().size(); i++) {
			if (listarFuncionarios().get(i).getCpf().equals(cpf)) {
				aux = listarFuncionarios().get(i);
			}
		}
		return aux;
	}
	
}
