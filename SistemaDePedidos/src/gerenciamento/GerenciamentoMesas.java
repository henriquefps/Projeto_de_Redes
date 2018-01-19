package gerenciamento;

import java.util.ArrayList;

import beans.Mesa;
import interfaces.IRepositorioMesas;
import repositorios.RepositorioMesas;

public class GerenciamentoMesas {
	private IRepositorioMesas mesas = RepositorioMesas.getInstance();
	
	public void cadastrarMesa(Mesa a) {
		if (a != null && !existe(a)){
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
	
	public boolean existe(Mesa a){
		for (int i = 0; i < listarMesas().size(); i++) {
			if (listarMesas().get(i).getId() == a.getId()) {
				return true;
			}
		}
		return false;
	}
	
	
}
