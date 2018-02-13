package repositorios;

import java.util.ArrayList;

import beans.Mesa;
import interfaces.IRepositorioFuncionarios;
import interfaces.IRepositorioMesas;

public class RepositorioMesas implements IRepositorioMesas{
	
	private static RepositorioMesas instance;
	private ArrayList<Mesa> listaDeMesas;
	
	private RepositorioMesas() {
		listaDeMesas = new ArrayList<Mesa>();
	}
	
	public static RepositorioMesas getInstance() {
		if(instance == null) {
			instance = new RepositorioMesas();
		}
		return instance;
	}
	
	public void adicionarMesa(Mesa e) {
		listaDeMesas.add(e);
		Repositorio_Servidor.atualizarListas(false);
	}
	
	public void removerMesa(Mesa e) {
		listaDeMesas.remove(e);
		Repositorio_Servidor.atualizarListas(false);
	}
	
	public ArrayList<Mesa> getListaDeMesas(){
		return listaDeMesas;
	}

	/**
	 * @param listaDeMesas the listaDeMesas to set
	 */
	public void setListaDeMesas(ArrayList<Mesa> listaDeMesas) {
		this.listaDeMesas = listaDeMesas;
	}
	
	
}
