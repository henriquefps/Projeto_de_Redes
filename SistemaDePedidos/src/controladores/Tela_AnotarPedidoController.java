package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Bebida;
import beans.Item;
import beans.Pedido;
import beans.Prato;
import fachada.Fachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class Tela_AnotarPedidoController implements Initializable {
	@FXML
	private TextField idMesaTextField;

	@FXML
	private TableView<Prato> pratosTableView;
	@FXML
	private TableView<Bebida> bebidasTableView;

	@FXML
	private TableColumn<Prato, String> colunaPratoNome;
	@FXML
	private TableColumn<Prato, String> colunaPratoValor;
	@FXML
	private TableColumn<Bebida, String> colunaBebidaNome;
	@FXML
	private TableColumn<Bebida, String> colunaBebidaValor;

	@FXML
	private TextArea descricaoTextArea;
	@FXML
	private TextArea itensTextArea;

	private ArrayList<Item> itensDoPedido = null;
	private Prato pratoSelecionado = null;
	private Bebida bebidaSelecionada = null;

	private String itens;
	
	@FXML
	public void adicionarPrato() {
		if (itensDoPedido == null) {
			itensDoPedido = new ArrayList<Item>();
		}
		
		if (pratoSelecionado != null) {
			itensDoPedido.add(pratoSelecionado);
			itens = itens + "- " + pratoSelecionado.getNome() + "\n";
			itensTextArea.setText(itens);
		}
	}

	@FXML
	public void adicionarBebida() {
		if (itensDoPedido == null) {
			itensDoPedido = new ArrayList<Item>();
		}
		
		if (bebidaSelecionada != null) {
			itensDoPedido.add(bebidaSelecionada);
			itens = itens + "- " + pratoSelecionado.getNome() + "\n";
			itensTextArea.setText(itens);
		}
	}

	@FXML
	public void cancelarPedido() {
		itensDoPedido = null;
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuGarcom());
	}

	@FXML
	public void finalizarPedido() {
		if (itensDoPedido != null && itensDoPedido.size() > 0 && Fachada.getInstance().existe(Integer.parseInt(idMesaTextField.getText()))) {
			Pedido pedido = new Pedido(Fachada.getInstance().listarPedido().size());
			pedido.setItens(itensDoPedido);
			pedido.setPronto(false);
			Fachada.getInstance().buscarMesa(Integer.parseInt(idMesaTextField.getText())).getPedidos().add(pedido);
			Fachada.getInstance().cadastrarPedido(pedido);
			itensDoPedido = null;
			itens = "";
			ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuGarcom());
		}
	}

	private void preencherTabelas() {
		ArrayList<Prato> listaDePratos = Fachada.getInstance().listarPratos();
		colunaPratoNome.setCellValueFactory(new Callback<CellDataFeatures<Prato, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Prato, String> todosOsPratos) {
				return new SimpleStringProperty(todosOsPratos.getValue().getNome());
			}
		});
		colunaPratoValor.setCellValueFactory(new Callback<CellDataFeatures<Prato, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Prato, String> todosOsPratos) {
				return new SimpleStringProperty(Double.toString(todosOsPratos.getValue().getValor()));
			}
		});
		pratosTableView.setItems(FXCollections.observableArrayList(listaDePratos));
		pratosTableView.refresh();

		ArrayList<Bebida> listaDeBebidas = Fachada.getInstance().listarBebidas();
		colunaBebidaNome.setCellValueFactory(new Callback<CellDataFeatures<Bebida, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Bebida, String> todosAsBebidas) {
				return new SimpleStringProperty(todosAsBebidas.getValue().getNome());
			}
		});
		colunaBebidaValor
				.setCellValueFactory(new Callback<CellDataFeatures<Bebida, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Bebida, String> todosAsBebidas) {
						return new SimpleStringProperty(Double.toString(todosAsBebidas.getValue().getValor()));
					}
				});
		bebidasTableView.setItems(FXCollections.observableArrayList(listaDeBebidas));
		bebidasTableView.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabelas();
	}

	@FXML
	public void selecionarBebida() {
		bebidaSelecionada = bebidasTableView.getSelectionModel().getSelectedItem();
		if (bebidaSelecionada != null) {
			descricaoTextArea.setText(bebidaSelecionada.getTamanho());
		}
	}

	@FXML
	public void selecionarPrato() {
		pratoSelecionado = pratosTableView.getSelectionModel().getSelectedItem();
		if (pratoSelecionado != null) {
			descricaoTextArea.setText(
					pratoSelecionado.getDescricao() + "\nServe Pessoas: " + pratoSelecionado.getServeNPessoas());
		}
	}
}
