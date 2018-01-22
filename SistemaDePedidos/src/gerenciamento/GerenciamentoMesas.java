package gerenciamento;

import java.util.ArrayList;

import beans.Mesa;
import interfaces.IRepositorioMesas;
import repositorios.RepositorioMesas;

public class GerenciamentoMesas {
	private IRepositorioMesas mesas = RepositorioMesas.getInstance();
	
	public void cadastrarMesa(Mesa a) {
		if (a != null && !existe(a.getId())){
			mesas.adicionarMesa(a);
		}
	}

	public void removerMesa(Mesa a) {
		if (a != null) {
			mesas.removerMesa(a);
		}
	}
	
	public ArrayList<Mesa> listarMesas(){
		return mesas.getListaDeMesas();
	}
	
	public Mesa buscarMesa(int id){
		Mesa procurado = null;
		for (int i = 0; i < listarMesas().size(); i++) {
			if (listarMesas().get(i).getId() == id) {
				procurado = listarMesas().get(i);
			}
		}
		return procurado;
	}
	
	public boolean existe(int id){
		for (int i = 0; i < listarMesas().size(); i++) {
			if (listarMesas().get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	
}
