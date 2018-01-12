package interfaces;

import java.util.ArrayList;

import beans.Mesa;

public interface IRepositorioMesas {
	
	public abstract void adicionarMesa(Mesa e);
	public abstract void removerMesa(Mesa e);
	public abstract ArrayList<Mesa> getListaDeMesas();
}
