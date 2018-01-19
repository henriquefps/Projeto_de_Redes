package gerenciamento;

import java.util.ArrayList;

import beans.Bebida;
import beans.Item;
import beans.Prato;
import interfaces.IRepositorioItens;
import repositorios.RepositorioItens;

public class GerenciamentoItens {
	private IRepositorioItens itens = RepositorioItens.getInstance();

	public void cadastrarPrato(Prato a) {
		if (a != null) {
			itens.adicionarItem(a);
		}
	}

	public void cadastrarBebida(Bebida a) {
		if (a != null){
			itens.adicionarItem(a);
		}
	}

	public void removerItem(Item a) {
		if (a != null) {
			itens.removerItem(a);
		}
	}
	
	public ArrayList<Item> listarItens(){
		return itens.getListaDeItens();
	}
	
	public ArrayList<Prato> listarPratos(){
		ArrayList<Prato> aux = new ArrayList<Prato>();
		for (int i = 0; i < listarItens().size(); i++) {
			if(listarItens().get(i) instanceof Prato){
				aux.add((Prato) listarItens().get(i));
			}
		}
		return aux;
	}
	
	public ArrayList<Bebida> listarBebidas(){
		ArrayList<Bebida> aux = new ArrayList<Bebida>();
		for (int i = 0; i < listarItens().size(); i++) {
			if(listarItens().get(i) instanceof Bebida){
				aux.add((Bebida) listarItens().get(i));
			}
		}
		return aux;
	}
	
	
}
