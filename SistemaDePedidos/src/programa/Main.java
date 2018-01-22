package programa;

import beans.Cozinheiro;
import beans.Garcom;
import controladores.ScreenManager;
import fachada.Fachada;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public void scriptsPovoamento(){
		Fachada.getInstance().cadastrarCozinheiro(new Cozinheiro("0000", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarCozinheiro(new Cozinheiro("0000", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarCozinheiro(new Cozinheiro("0001", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarGarcom(new Garcom("0100", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarGarcom(new Garcom("0101", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarGarcom(new Garcom("0102", Fachada.getInstance().listarFuncionarios().size()));
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		scriptsPovoamento();
		ScreenManager.getInstance().setMainStage(primaryStage);
		ScreenManager.getMainStage().setTitle("Sistemas de Pedidos");
		ScreenManager.getMainStage().setResizable(false);
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}

}
