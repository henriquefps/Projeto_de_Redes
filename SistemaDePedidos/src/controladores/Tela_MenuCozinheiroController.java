package controladores;

import beans.Prato;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Tela_MenuCozinheiroController {
	@FXML private TableView<Prato> tabelaPedidos;
	@FXML private TableColumn<Prato, String> colunaNomeItem;
	@FXML private TableColumn<Prato, String>colunaIdItem;
	
	@FXML public void marcarComoPronto(){
		//TODO
	}
	@FXML public void adicionarNovoItem(){
		//TODO
	}
	@FXML public void voltarParaLogin(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}
}
