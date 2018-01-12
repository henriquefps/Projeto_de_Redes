package repositorios;

import java.util.ArrayList;

import beans.Item;
import interfaces.IRepositorioFuncionarios;
import interfaces.IRepositorioItens;

public class RepositorioItens implements IRepositorioItens {
	
	private static RepositorioItens instance;
	private ArrayList<Item> listaDeItens;
	
	private RepositorioItens() {
		listaDeItens = new ArrayList<Item>();
	}
	
	public static RepositorioItens getInstance() {
		if(instance == null) {
			instance = new RepositorioItens();
		}
		return instance;
	}
	
	public void adicionarItem(Item e) {
		listaDeItens.add(e);
	}
	
	public void removerItem(Item e) {
		listaDeItens.remove(e);
	}
	
	public ArrayList<Item> getListaDeItens(){
		return listaDeItens;
	}
}
