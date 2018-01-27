package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Pedido;
import beans.Prato;
import fachada.Fachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_MenuCozinheiroController implements Initializable{
	@FXML private TableView<Pedido> tabelaPedidos;
	@FXML private TableColumn<Pedido, String> colunaItens;
	@FXML private TableColumn<Pedido, String>colunaIdMesa;
	
	private Pedido selecionado = null;
	
	@FXML public void marcarComoPronto(){
		if (selecionado != null) {
			selecionado.setPronto(true);
			preencherTabela();
		}
	}
	@FXML public void adicionarNovoItem(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdicionarItem());
	}
	@FXML public void voltarParaLogin(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}
	
	@FXML public void selecionarPrato(){
		selecionado = tabelaPedidos.getSelectionModel().getSelectedItem();
	}
	
	private void preencherTabela(){
		ArrayList<Pedido> listaDePedidos = Fachada.getInstance().listarPedidosNaoProntos();
		colunaItens.setCellValueFactory(new Callback<CellDataFeatures<Pedido, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Pedido, String> todosOsPedidos) {
				return new SimpleStringProperty(Fachada.getInstance().pratosToString(todosOsPedidos.getValue()));
			}
		});
		colunaIdMesa.setCellValueFactory(new Callback<CellDataFeatures<Pedido, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Pedido, String> todosOsPedidos) {
				return new SimpleStringProperty(Integer.valueOf(todosOsPedidos.getValue().getIdMesa()).toString());
			}
		});
		tabelaPedidos.setItems(FXCollections.observableArrayList(listaDePedidos));
		tabelaPedidos.refresh();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
}
