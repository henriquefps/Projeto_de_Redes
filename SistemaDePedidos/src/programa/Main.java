package programa;

import controladores.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScreenManager.getInstance().setMainStage(primaryStage);
		ScreenManager.getMainStage().setTitle("Cine EasyPlex");
		ScreenManager.getMainStage().setResizable(false);
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
	}

}
