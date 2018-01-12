package interfaces;

import java.util.ArrayList;

import beans.Funcionario;

public interface IRepositorioFuncionarios {

	public abstract void adicionarFuncionario(Funcionario e);
	public abstract void removerFuncionario(Funcionario e);
	public abstract ArrayList<Funcionario> getListaDeFuncionarios();
}
