package programa;

import beans.Bebida;
import beans.Cozinheiro;
import beans.Garcom;
import beans.Mesa;
import beans.Prato;
import controladores.ScreenManager;
import fachada.Fachada;
import javafx.application.Application;
import javafx.stage.Stage;
import repositorios.Repositorio_Servidor;

public class Main extends Application{

	public void scriptsPovoamento(){
		Fachada.getInstance().cadastrarCozinheiro(new Cozinheiro("0000", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarCozinheiro(new Cozinheiro("0000", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarCozinheiro(new Cozinheiro("0001", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarGarcom(new Garcom("0100", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarGarcom(new Garcom("0101", Fachada.getInstance().listarFuncionarios().size()));
		Fachada.getInstance().cadastrarGarcom(new Garcom("0102", Fachada.getInstance().listarFuncionarios().size()));
		
		Fachada.getInstance().cadastrarPrato(new Prato(Fachada.getInstance().listarItens().size(),
				25, "Picanha Individual", "Picanha acebolada, acompanha arroz e batata", 1));
		Fachada.getInstance().cadastrarPrato(new Prato(Fachada.getInstance().listarItens().size(),
						35, "Lasanha Bolonhesa", "Lasahna Bolonhesa, acompanha arroz e macarrão", 2));
		Fachada.getInstance().cadastrarPrato(new Prato(Fachada.getInstance().listarItens().size(),
				25, "Risoto aos quatro queijos", "Risoto de queijo parmesão, mussarela, cheddar e gorgonzola", 1));
		Fachada.getInstance().cadastrarBebida(new Bebida(Fachada.getInstance().listarItens().size(), 
				5, "Agua Mineral", "500 ml"));
		Fachada.getInstance().cadastrarBebida(new Bebida(Fachada.getInstance().listarItens().size(), 
				3, "Agua Mineral", "300 ml"));
		Fachada.getInstance().cadastrarBebida(new Bebida(Fachada.getInstance().listarItens().size(), 
				5, "Chá Leão Mate: Pessego", "500 ml"));
		
		Fachada.getInstance().cadastrarMesa(new Mesa(Fachada.getInstance().listarMesas().size()));
		Fachada.getInstance().cadastrarMesa(new Mesa(Fachada.getInstance().listarMesas().size()));
		Fachada.getInstance().cadastrarMesa(new Mesa(Fachada.getInstance().listarMesas().size()));
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Repositorio_Servidor.atualizarListas(true);
		ScreenManager.getInstance().setMainStage(primaryStage);
		ScreenManager.getMainStage().setTitle("Sistemas de Pedidos");
		ScreenManager.getMainStage().setResizable(false);
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}

}
