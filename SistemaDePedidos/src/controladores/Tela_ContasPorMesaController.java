package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Mesa;
import beans.Pedido;
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

public class Tela_ContasPorMesaController implements Initializable{

    @FXML
    private TableView<Mesa> tabelaMesas;

    @FXML
    private TableColumn<Mesa, String> colunaIdMesa;

    @FXML
    private TableColumn<Mesa, String> colunaValorConta;

    private Mesa selecionada = null;
    
    @FXML
    void finalizarConta() {
    	if (selecionada != null) {
			selecionada.setPedidos(new ArrayList<Pedido>());
			preencherTabela();
		}
    }

    @FXML
    void selecionarMesa() {
    	selecionada = tabelaMesas.getSelectionModel().getSelectedItem();
    }

    @FXML
    void voltarParaMenuGarcom() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuGarcom());
    }
    
    private void preencherTabela(){
		ArrayList<Mesa> listaDeMesas  = Fachada.getInstance().listarMesas();
		colunaIdMesa.setCellValueFactory(new Callback<CellDataFeatures<Mesa, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Mesa, String> todosAsMesas) {
				return new SimpleStringProperty(Integer.valueOf(todosAsMesas.getValue().getId()).toString());
			}
		});
		colunaValorConta.setCellValueFactory(new Callback<CellDataFeatures<Mesa, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Mesa, String> todosAsMesas) {
				return new SimpleStringProperty(Double.valueOf(Fachada.getInstance().calcularConta(todosAsMesas.getValue().getPedidos())).toString());
			}
		});
		tabelaMesas.setItems(FXCollections.observableArrayList(listaDeMesas));
		tabelaMesas.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
	
	@FXML public void adicionarMesa(){
		Fachada.getInstance().cadastrarMesa(new Mesa(Fachada.getInstance().listarMesas().size()));
		preencherTabela();
	}
	
	@FXML public void removerMesa(){
		Fachada.getInstance().removerMesa(Fachada.getInstance().buscarMesa(Fachada.getInstance().listarMesas().size() - 1));
		preencherTabela();
	}

}
