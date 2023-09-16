package mvc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=tarefa_apex;encrypt=false";
	public static final String USER = "sa";
	public static final String PASS = "12345678";

	public static Connection getConnection() {

		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("erro na conexão com banco de dados", e);
		}
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("erro ao fechar a conexão com banco de dados.", e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement) {
		try {
			closeConnection(connection);
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("erro ao fechar a conexão com banco de dados.", e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			closeConnection(connection, statement);
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("erro ao fechar a conexão com banco de dados.", e);
		}
	}
}
