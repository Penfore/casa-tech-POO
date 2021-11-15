package src.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDao<VO> implements BaseInterDao<VO> {
	private static Connection conn = null;

	// DADOS CONEX�O FULVIN :)
	// private static final String url =
	// "jdbc:postgresql://localhost:5432/Casa-Tech-POO";
	// private static final String usuario = "postgres";
	// private static final String senha = "";

	// DADOS DE CONEX�O DA ISABELE :)
	 //private static final String url =
	 //"jdbc:postgresql://localhost:5432/postgres?currentSchema=casatech";
	 //private static final String usuario = "postgres";
	 //private static final String senha = "123";

	// DADOS DE CONEX�O DO DAVI :D
	private static final String url = "jdbc:postgresql://localhost:5432/CasaTech-POO";
	private static final String usuario = "postgres";
	private static final String senha = "1234";

	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, usuario, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;

		} else {
			return conn;
		}
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public abstract void store(VO vo) throws SQLException;
	public abstract void updateById(VO vo) throws SQLException;
	public abstract void removeById(VO vo) throws SQLException;
	public abstract ResultSet index() throws SQLException;
	public abstract ResultSet show(VO vo) throws SQLException;
}