package gerenciamento;

import java.util.ArrayList;

import beans.Bebida;
import beans.Item;
import beans.Pedido;
import beans.Prato;
import interfaces.IRepositorioPedidos;
import repositorios.RepositorioPedidos;

public class GerenciamentoPedidos {
	private IRepositorioPedidos pedidos = RepositorioPedidos.getInstance();

	public void cadastrarPedido(Pedido a) {
		if (a != null) {
			pedidos.adicionarPedido(a);
		}
	}

	public void removerPedido(Pedido a) {
		if (a != null) {
			pedidos.removerPedido(a);
		}
	}

	public ArrayList<Pedido> listarPedido() {
		return pedidos.getListaDePedidos();
	}

	public ArrayList<Prato> listarPratosDosPedidosNaoProntos() {
		ArrayList<Prato> aux = new ArrayList<Prato>();
		for (int i = 0; i < listarPedido().size(); i++) {
			if (!listarPedido().get(i).getPronto()) {
				for (int j = 0; j < listarPedido().get(i).getItens().size(); j++) {
					if (listarPedido().get(i).getItens().get(j) instanceof Prato) {
						aux.add((Prato) listarPedido().get(i).getItens().get(j));
					}
				}
			}
		}
		return aux;
	}
	
	public boolean isPedidoPronto(Pedido a){
		boolean is = true;
		for (int i = 0; i < a.getItens().size(); i++) {
			if (a.getItens().get(i) instanceof Prato && !((Prato) a.getItens().get(i)).isPronto()) {
				is = false;
			}
		}
		return is;
	}
	
	public String pratosToString(Pedido a){
		String aux = "";
		for (int i = 0; i < a.getItens().size(); i++) {
			if (a.getItens().get(i) instanceof Prato) {
				aux = aux + ((Prato) a.getItens().get(i)).getNome() + ", ";
			}
		}
		if (aux.equals("")) {
			aux = "Nenhum prato neste pedido.";
		}
		return aux;
	}
	public ArrayList<Pedido> listarPedidosNaoProntos(){
		ArrayList<Pedido> aux = new ArrayList<Pedido>();
		for (int i = 0; i < listarPedido().size(); i++) {
			if (!listarPedido().get(i).getPronto()) {
				aux.add(listarPedido().get(i));
			}
		}
		return aux;
	}
}
