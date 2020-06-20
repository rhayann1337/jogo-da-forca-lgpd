package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private static Connection connection;

	public static Connection getConnection() {
		try {

			String url = "jdbc:postgresql://ec2-3-222-150-253.compute-1.amazonaws.com:5432/ddbd9u62q0jitm";
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, "gmxvaoithqaecu", "858c85d538faa1eef46afc9640e387afed3b9aba7f2d7bece49526570232e610");
		} catch (SQLException ex) {
			System.out.println("Erro na conexão." + ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void closeDataSource() {

	}

}
