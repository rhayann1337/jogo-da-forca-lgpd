package br.com.jogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import br.com.jogo.model.Palavra;

public class Controller {
	private List<Palavra> listaPalavras;

	public boolean validarJogada(String palavra, char letra) {
		return palavra.contains(String.valueOf(letra));
	}
	
	public List<Palavra> inicializarListaPalavras() {
		Palavra palavra1 = new Palavra("lgpd", "LGPD foi feita para proteger seus dados pessoais.", "DICA : Lei que protege os dados dos usuários, tem 4 letras.");
		Palavra palavra2 = new Palavra("dados", "É protegido pela lei LGPD", "DICA : Objeto protegido pela lei LGPD");
		Palavra palavra3 = new Palavra("usuario", "Pode utilizar seus acessos, pois é protegido pela LGPD", "DICA : Quem é protegido pela lei");
		Palavra palavra4 = new Palavra("criptografia", "É utilizada para proteger os dados.", "DICA : Ferramenta utilizada para proteger os dados.");
		Palavra palavra5 = new Palavra("ataque cibernetico", "É um dos riscos que a LGPD luta contra.", "DICA : Contém espaço e é um dos riscos a serem evitados.");
		Palavra palavra6 = new Palavra("violacao de dados", "É um dos riscos que a LGPD ajuda a proteger seus dados.", "DICA : Contém espaço e é um dos riscos a serem evitados.");
		Palavra palavra7 = new Palavra("lei geral de proteção de dados", "Significado", "DICA : Significado da lei.");
		Palavra palavra8 = new Palavra("agosto", "Mês que entrou em vigor a lei.", "DICA : 12-8+2-4+10-4 = ???");
		Palavra palavra9 = new Palavra("banco de dados", "É utilizado para hospedar os dados criptografados.", "DICA : Contém espaço e guarda informações.");
		Palavra palavra10 = new Palavra("exposed", "LGPD foi criada para evitar a exposição de dados pessoais.", "DICA : Quando vaza os dados é conhecida como exposição.");
		
		listaPalavras = new ArrayList<>();
		listaPalavras.add(palavra1);
		listaPalavras.add(palavra2);
		listaPalavras.add(palavra3);
		listaPalavras.add(palavra4);
		listaPalavras.add(palavra5);
		listaPalavras.add(palavra6);
		listaPalavras.add(palavra7);
		listaPalavras.add(palavra8);
		listaPalavras.add(palavra9);
		listaPalavras.add(palavra10);
		
		
		return listaPalavras;
	}

	public String gerarPalavraEscondida(Palavra palavra) {
		String palavraEscondida = new String();
		for (int i = 0; i < palavra.getPalavra().length(); i++) {
			palavraEscondida += "_";
		}
		return palavraEscondida;
	}

	public String mostrarAcertos(String palavraEscondida, Palavra palavra, char letra) {
		char[] arrayPalavraEscondida = palavraEscondida.toCharArray();
		char[] arrayPalavra = palavra.getPalavra().toCharArray();

		for (int i = 0; i < arrayPalavra.length; i++) {
			if (arrayPalavra[i] == letra) {
				arrayPalavraEscondida[i] = letra;
			}
		}
		palavraEscondida = String.copyValueOf(arrayPalavraEscondida);
	
		return palavraEscondida;
	}
	public void limparTela() throws IOException {
		System.out.println("\n\n\n");
	}
}	
