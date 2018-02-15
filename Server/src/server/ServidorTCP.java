package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;

import beans.Cozinheiro;
import beans.Funcionario;
import beans.NaoEscrever;

public class ServidorTCP {
	private static Object[] listas;

	public static void main(String[] args) {
		try {
			//Cria um ServerSocket(Servidor) ouvindo na porta 12345	
			ServerSocket servidor = new ServerSocket(12345);
			System.out.println("Servidor ouvindo a porta 12345");
			
			while (true) {

				// Espera uma requisição
				Socket cliente = servidor.accept();
				System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

				// Para retorna para o cliente o que foi solicitado ao servidor
				ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

				// Dados que estão chegando do cliente para o servidor
				ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

				// Atualiza as listas com as do programa
				System.err.println("entrou");
				
				//Pega dados que chegaram do cliente e salva no servidor
				RepositorioObject.getInstance().setListas((Object[]) entrada.readObject());
				
				// Atualiza as informações da variavel listas
				listas = RepositorioObject.getInstance().getListas();

				// Escreve a lista como saida do server
				saida.flush();
				//Manda para o cliente
				saida.writeObject(listas);
				saida.close();

				// Encerra conexão do socket
				cliente.close();
			}
		} catch (Exception e) {
			System.out.println("Erro Server: " + e.getMessage());
		} finally {

		}
	}

}
