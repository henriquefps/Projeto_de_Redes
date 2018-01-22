package controladores;

import javafx.fxml.FXML;

public class Tela_MenuGarcomController {
	
	@FXML public void verContasPorMesa(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaContasPorMesa());
	}
	@FXML public void anotarPedido(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAnotarPedido());
	}
	@FXML public void voltarParaLogin(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}
	
}
