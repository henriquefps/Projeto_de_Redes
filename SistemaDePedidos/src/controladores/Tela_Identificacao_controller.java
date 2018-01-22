package controladores;

import beans.Cozinheiro;
import beans.Funcionario;
import beans.Garcom;
import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Tela_Identificacao_controller {

	@FXML
	private TextField cpfTextField;

	@FXML
	public void logarComCpf() {
		Funcionario aux = Fachada.getInstance().buscarFuncionario(cpfTextField.getText());
		if (aux != null && aux instanceof Garcom) {
			ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuGarcom());
		} else if(aux != null && aux instanceof Cozinheiro){
			ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuCozinheiro());
		}
	}
}
