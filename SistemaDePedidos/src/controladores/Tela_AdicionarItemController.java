package controladores;

import beans.Bebida;
import beans.Prato;
import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Tela_AdicionarItemController {

	@FXML
	private TextField nomePratoTextField;
	@FXML
	private TextArea descricaoPratoTextArea;
	@FXML
	private TextField valorPratoTextField;
	@FXML
	private TextField nPessoasTextField;
	@FXML
	private TextField nomeBebidaTextField;
	@FXML
	private TextField tamanhoBebidaTextField;
	@FXML
	private TextField valorBebidaTextField;

	@FXML
	public void adicionarPrato() {
		if (!nomePratoTextField.getText().equals("") && !descricaoPratoTextArea.getText().equals("")
				&& !valorPratoTextField.getText().equals("") && !nPessoasTextField.getText().equals("")) {
			Fachada.getInstance()
					.cadastrarPrato(new Prato(Fachada.getInstance().listarItens().size(),
							Double.parseDouble(valorPratoTextField.getText()), nomePratoTextField.getText(),
							descricaoPratoTextArea.getText(), Integer.parseInt(nPessoasTextField.getText())));
			
			nomePratoTextField.setText("");
			descricaoPratoTextArea.setText("");
			valorPratoTextField.setText("");
			nPessoasTextField.setText("");
		}
	}

	@FXML
	public void adicionarBebida() {
		if (!nomeBebidaTextField.getText().equals("") && !valorBebidaTextField.getText().equals("")
				&& !tamanhoBebidaTextField.getText().equals("")) {
			Fachada.getInstance()
					.cadastrarBebida(new Bebida(Fachada.getInstance().listarItens().size(),
							Double.parseDouble(valorBebidaTextField.getText()), nomeBebidaTextField.getText(),
							tamanhoBebidaTextField.getText()));
			nomeBebidaTextField.setText("");
			tamanhoBebidaTextField.setText("");
			valorBebidaTextField.setText("");
		}
	}

	@FXML
	public void voltarParaMenuCozinheiro() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuCozinheiro());
	}
}
