package br.com.jogo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.com.jogo.controller.Controller;
import br.com.jogo.controller.ControllerLogin;
import br.com.jogo.model.Palavra;
import br.com.jogo.model.Usuario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		ControllerLogin controllerLogin = new ControllerLogin();
		Controller controller = new Controller();
		String letra = "";
		int indicePalavra = 0;
		Boolean loginSucesso = true;
		Boolean cadastroSucesso = true;
		Usuario usuario = null;
		int erros = 0;
		Boolean opcao = false;
		int perdeu = 0;

		// INICIO DO JOGO
		System.out.println(" ______________________________");
		System.out.println("|                              |");
		System.out.println("|Pressione 1 para logar.       |");
		System.out.println("|Pressione 2 para se cadastrar.|");
		System.out.println("|______________________________|\n");
		switch (lerTeclado(1)) {
		case "1":
			do {
				System.out.println(" __________________");
				System.out.println("|                  |");
				System.out.println("|Insira seu usuário|");
				System.out.println("|__________________|\n");
				String nome = lerTeclado(1);
				System.out.println(" ________________");
				System.out.println("|                |");
				System.out.println("|Insira sua senha|");
				System.out.println("|________________|\n");
				String senha = lerTeclado(1);
				usuario = controllerLogin.buscarUsuario(nome, senha);
				if (usuario == null) {
					System.out.println(" ____________________________");
					System.out.println("|                            |");
					System.out.println("|Usuário ou senha inválidos. |");
					System.out.println("|Insira novamente seus dados.|");
					System.out.println("|____________________________|\n");
					loginSucesso = false;
				}
			} while (!loginSucesso);
			System.out.println(" ____________________________");
			System.out.println("|                            |");
			System.out.println("|LOGIN REALIZADO COM SUCESSO.|");
			System.out.println("|____________________________|\n");
			break;

		case "2":
			do {
				System.out.println("Bem-vindo ao cadastro de usuários.");
				System.out.println(" __________________");
				System.out.println("|                  |");
				System.out.println("|Insira seu usuário|");
				System.out.println("|__________________|\n");
				String nome = lerTeclado(1);
				usuario = controllerLogin.verificarConta(nome);
				if (usuario == null) {
					System.out.println(" ________________");
					System.out.println("|                |");
					System.out.println("|Insira sua senha|");
					System.out.println("|________________|\n");
					String senha = lerTeclado(1);
					System.out.println(" ________________");
					System.out.println("|                |");
					System.out.println("|Insira seu email|");
					System.out.println("|________________|\n");
					String email = lerTeclado(1);
					usuario = controllerLogin.criarUsuario(nome, senha, email);
					System.out.println(" _______________________________");
					System.out.println("|                               |");
					System.out.println("|USUARIO CADASTRADO COM SUCESSO.|");
					System.out.println("|_______________________________|\n");
				} else {
					System.out.println(" ______________________");
					System.out.println("|                      |");
					System.out.println("|USUARIO JÁ CADASTRADO.|");
					System.out.println("|______________________|\n");
					cadastroSucesso = false;
				}
			} while (!cadastroSucesso);

			break;

		default:
			System.out.println(" _______________");
			System.out.println("|               |");
			System.out.println("|Opção inválida.|");
			System.out.println("|_______________|");
		}
		System.out.println(" ________________________________________");
		System.out.println("|                                        |");
		System.out.println("|           Jogo da Forca LGPD           |");
		System.out.println("|Pressione 1 para jogar                  |");
		System.out.println("|Pressione 2 para sair                   |");
		System.out.println("|Pressione 3 para saber sobre a lei LGPD |");
		System.out.println("|________________________________________|\n");
		do {
			switch (lerTeclado(1)) {
			case "1":
				System.out.println(" _____________________________________________________________________________________");
				System.out.println("|                                                                                     |");
				System.out.println("|Esse jogo tem o intuito de disserminar o conhecimento da lei sobre proteção de dados.|");
				System.out.println("|_____________________________________________________________________________________|\n");
				
				for(perdeu = 0; perdeu <10;) {
				List<Palavra> listaPalavras = controller.inicializarListaPalavras();
				String palavraEscondida = controller.gerarPalavraEscondida(listaPalavras.get(indicePalavra));
				System.out.println(listaPalavras.get(indicePalavra).getDescricao());
				System.out.println(listaPalavras.get(indicePalavra).getDica());
				System.out.println(palavraEscondida);
				System.out.println("Insira a letra que está palavra possui.");
			    	
			    	while (!letra.equals("100")) {
			    		letra = lerTeclado(1);
			    		System.out.println(letra);
			    		if (controller.validarJogada(listaPalavras.get(indicePalavra).getPalavra(), letra.charAt(0))) {
			    			palavraEscondida = controller.mostrarAcertos(palavraEscondida, listaPalavras.get(indicePalavra),
			    					letra.charAt(0));
			    			controller.limparTela();
			    			System.out.println(palavraEscondida);
			    			System.out.println(" ________________________________________");
			    			System.out.println("|                                        |");
			    			System.out.println("|Você acertou a letra, insira a próxima. |");
			    			System.out.println("|________________________________________|\n");
			    		} else {
			    			erros++;
			    			controller.limparTela();
			    			System.out.println(" ________________________________________________________");
			    			System.out.println("|                                                        |");
			    			System.out.println("|Essa palavra não contém essa letra.                     |");
			    			System.out.println("|A quantidade de erros nessa palavra foi no total de "+ erros + "  |");
			    			System.out.println("|________________________________________________________|\n");

			    			
			    		}
			    		if (!palavraEscondida.contains("_")) {
			    			controller.limparTela();
			    			System.out.println(" _________________________________");
			    			System.out.println("|                                 |");
			    			System.out.println("|Parabéns, você acertou a palavra!|");
			    			System.out.println("|_________________________________|\n");
			    			System.out.println("");
			    			erros = 0;
			    			indicePalavra++;
			    			if (indicePalavra == listaPalavras.size()) {
				    			System.out.println(" ________________________________________________");
				    			System.out.println("|                                                |");
				    			System.out.println("|Você é muito esperto, acertou todas as palavras.|");
				    			System.out.println("|________________________________________________|\n");
			    				break;
			    			}
			    			System.out.println(" ____________________________________");
			    			System.out.println("|                                    |");
			    			System.out.println("|          PRÓXIMA PALAVRA           |");
			    			System.out.println("|____________________________________|\n");
			    			palavraEscondida = controller.gerarPalavraEscondida(listaPalavras.get(indicePalavra));
							System.out.println(listaPalavras.get(indicePalavra).getDescricao());
							System.out.println(listaPalavras.get(indicePalavra).getDica());
			    			System.out.println("Insira a letra que está palavra possui.");
			    			
			    		}
			    		
			    		if (erros > 10) {
			    			controller.limparTela();
			    			System.out.println(" ____________________________________________");
			    			System.out.println("|                                            |");
			    			System.out.println("|Você perdeu, tente novamente desde o começo.|");
			    			System.out.println("|____________________________________________|\n");
			    			perdeu++;
			    			erros=0;
			    			indicePalavra=0;
			    			palavraEscondida = controller.gerarPalavraEscondida(listaPalavras.get(indicePalavra));
							System.out.println(listaPalavras.get(indicePalavra).getDescricao());
							System.out.println(listaPalavras.get(indicePalavra).getDica());
							System.out.println(palavraEscondida);
			    		}
			    		
			    	}
			    
			    }
				opcao = true;
				break;
			case "2":
				System.out.println(" __________________");
				System.out.println("|                  |");
				System.out.println("|Você saiu do jogo.|");
				System.out.println("|__________________|");
				opcao = true;
				break;
			case "3":
				System.out.println(" ________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
				System.out.println("|                                                                                                                                                                                                                                        |");
				System.out.println("|Lei Geral de Proteção de Dados Pessoais (LGPD ou LGPDP), Lei nº 13.709/2018, é a legislação brasileira que regula as atividades de tratamento de dados pessoais e que também altera os artigos 7º e 16 do Marco Civil da Internet.      |");
				System.out.println("|A legislação se fundamenta em diversos valores, como o respeito à privacidade; à autodeterminação informativa; à liberdade de expressão, de informação, comunicação e de opinião; à inviolabilidade da intimidade, da honra e da imagem |");
				System.out.println("|ao desenvolvimento econômico e tecnológico e a inovação; à livre iniciativa, livre concorrência e defesa do consumidor e aos direitos humanos de liberdade e dignidade das pessoas.                                                     |");
				System.out.println("|________________________________________________________________________________________________________________________________________________________________________________________________________________________________________|\n");
				opcao = true;
				break;
			default:
    			System.out.println(" _____________________________");
    			System.out.println("|                             |");
    			System.out.println("|Digite apenas opção 1,2 ou 3.|");
    			System.out.println("|_____________________________|\n");
				opcao = false;
				break;
			}

		} while (opcao = false);
		lerTeclado(0);
	}


	public static String lerTeclado(int status) {
		String valor = null;
		Scanner scanner = null;
		if (scanner == null)
			scanner = new Scanner(System.in);
		if (status == 0)
			scanner.close();
		else
			valor = scanner.nextLine();
		return valor;

	}

}
