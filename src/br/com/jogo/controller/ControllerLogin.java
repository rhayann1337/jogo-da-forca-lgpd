package br.com.jogo.controller;

import br.com.jogo.model.Usuario;
import br.com.jogo.utils.*;

public class ControllerLogin {
	public Usuario buscarUsuario(String nome, String senha) {
		Usuario usuario = null;
		if ((nome != null && !nome.isEmpty()) && (senha != null && !senha.isEmpty())) {
			usuario = new Usuario(Criptografia.criptografar(nome), Criptografia.criptografar(senha));
			usuario = usuario.buscarUsuario();
		}
		if (usuario != null && senha != null) {
			usuario.setNome(Criptografia.descriptografar(usuario.getNome()));
			usuario.setSenha(Criptografia.descriptografar(usuario.getSenha()));
		}
		return usuario;
	}

	public Usuario criarUsuario(String nome, String senha, String email) {
		Usuario usuario = null;
		if ((nome != null && !nome.isEmpty()) && (senha != null && !senha.isEmpty())
				&& (email != null && !email.isEmpty()) && (email.contains("@"))) {
			usuario = new Usuario(Criptografia.criptografar(nome), Criptografia.criptografar(senha),
					Criptografia.criptografar(email));
			usuario = usuario.criarUsuario();
		}
		return usuario;
	}

	public Usuario verificarConta(String nome) {
		Usuario usuario = null;
		if (nome != null && !nome.isEmpty()) {
			usuario = new Usuario(Criptografia.criptografar(nome));
			usuario = usuario.buscarConta();
		}
		return usuario;
	}

}
