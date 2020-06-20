package br.com.jogo.model;

public class Palavra {
	private String palavra;
	private String descricao;
	private String dica;
	
	public Palavra(String palavra, String descricao, String dica) {
		this.palavra = palavra;
		this.descricao = descricao;
		this.dica = dica;
	}
	
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	
}
