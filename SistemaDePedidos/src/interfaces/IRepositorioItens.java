package interfaces;

import java.util.ArrayList;

import beans.Item;

public interface IRepositorioItens {
	
	public abstract void adicionarItem(Item e);
	public abstract void removerItem(Item e);
	public abstract ArrayList<Item> getListaDeItens();
}
