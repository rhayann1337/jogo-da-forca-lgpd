package br.com.jogo.model;

import dao.UsuarioDAO;

public class Usuario {
	 String nome;
	 String senha;
	 String email;

	public Usuario() {}
	 
	public Usuario(String nome, String senha, String email) {
		setNome(nome);
		setSenha(senha);
		setEmail(email);
	}
	
	public Usuario(String nome, String senha) {
		setNome(nome);
		setSenha(senha);
	}
	public Usuario(String nome) {
		setNome(nome);
	}
	 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario buscarUsuario() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscarUsuario(this.nome, this.senha);
	}

	public Usuario criarUsuario() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.criarUsuario(this.nome, this.senha, this.email);
	}

	public Usuario buscarConta() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscarConta(this.nome);
	}
	
}




