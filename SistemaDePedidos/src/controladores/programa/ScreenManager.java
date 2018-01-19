package controladores.programa;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {

	private Scene telaLogin;
	private Scene telaAdicionarItem;
	private Scene telaAnotarPedido;
	private Scene telaContasPorMesa;
	private Scene telaMenuCozinheiro;
	private Scene telaMenuGarcom;
	private Scene telaID_Cozinheiro;
	private Scene telaID_Garcom;

	private static Stage mainStage;

	private static ScreenManager instance;

	private ScreenManager() {

	}

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	public static void setScene(Scene a) {
		mainStage.setScene(a);
		mainStage.show();
	}

	public static Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage stage) {
		mainStage = stage;
	}

	public Scene getTelaLogin() {
		try {
			telaLogin = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_Login.fxml")), 1280, 720);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaLogin;
	}

	public Scene getTelaAdicionarItem() {
		try {
			telaAdicionarItem = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_AdicionarItem.fxml")), 1280, 720);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaAdicionarItem;
	}

	public Scene getTelaAnotarPedido() {
		try {
			telaAnotarPedido = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_AnotarPedido.fxml")), 1280, 720);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaAnotarPedido;
	}

	public Scene getTelaContasPorMesa() {
		try {
			telaContasPorMesa = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_ContasPorMesa.fxml")), 1280, 720);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaContasPorMesa;
	}

	

	public Scene getTelaMenuCozinheiro() {
		try {
			telaMenuCozinheiro = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_MenuCozinheiro.fxml")), 1280, 720);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaMenuCozinheiro;
	}

	public Scene getTelaMenuGarcom() {
		try {
			telaMenuGarcom = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_MenuGarcom.fxml")), 1280, 720);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaMenuGarcom;
	}

	public Scene getTelaID_Cozinheiro() {
		try {
			telaID_Cozinheiro = new Scene(FXMLLoader.load(getClass().getResource("/graficos/TelaID_Cozinheiro.fxml")), 1280, 720);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaID_Cozinheiro;
	}

	public Scene getTelaID_Garcom() {
		try {
			telaID_Garcom = new Scene(FXMLLoader.load(getClass().getResource("/graficos/TelaID_Garcom.fxml")), 1280, 720);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaID_Garcom;
	}

}
