package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jogo.model.Usuario;

public class UsuarioDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public Usuario buscarUsuario(String nome, String senha) {
		Usuario usuario = null;
		try {
			con = DataSource.getConnection();
			if(con != null) {
				pst = con.prepareStatement("SELECT nome, senha, email FROM usuario WHERE nome = ? AND senha = ?");
				pst.setString(1, nome);
				pst.setString(2, senha);
				rs = pst.executeQuery();
				while(rs.next()) {
					usuario = new Usuario();
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setEmail(rs.getString("email"));
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}
	public Usuario criarUsuario(String nome, String senha, String email) {
		Usuario usuario = null;
		try {
			con = DataSource.getConnection();
			if(con != null) {
				pst = con.prepareStatement("INSERT INTO usuario (nome, senha, email) values (?,?,?)");
				pst.setString(1, nome);
				pst.setString(2, senha);
				pst.setString(3, email);
				pst.execute();
				
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}
	public Usuario buscarConta(String nome) {
		Usuario usuario = null;
		try {
			con = DataSource.getConnection();
			if(con != null) {
				pst = con.prepareStatement("SELECT nome FROM usuario WHERE nome = ?");
				pst.setString(1, nome);
				rs = pst.executeQuery();
				while(rs.next()) {
					usuario = new Usuario();
					usuario.setNome(rs.getString("nome"));
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return usuario;
	}	
}
