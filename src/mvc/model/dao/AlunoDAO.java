package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Aluno;

public class AlunoDAO {

	public void save(Aluno aluno) {
		String sql = "INSERT INTO aluno (nome, nota_um, nota_dois, nota_tres) VALUES (?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, aluno.getNome());
			statement.setInt(2, aluno.getNota_um());
			statement.setInt(3, aluno.getNota_dois());
			statement.setInt(4, aluno.getNota_tres());

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("erro ao salvar o aluno", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void update(Aluno aluno) {
		String sql = "UPDATE aluno SET nome = ?, nota_um = ?, nota_dois = ?, nota_tres = ? where codigo = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement(sql);

			statement.setString(1, aluno.getNome());
			statement.setInt(2, aluno.getNota_um());
			statement.setInt(3, aluno.getNota_dois());
			statement.setInt(4, aluno.getNota_tres());
			statement.setInt(5, aluno.getCodigo());

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("erro ao atualizar o projeto.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public List<Aluno> getALL() {
		String sql = "SELECT * FROM aluno ";

		List<Aluno> alunos = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;

		// classe que vai recuperar os dados do banco de dados
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			// enquanto existir dados no banco de dados
			while (resultSet.next()) {
				Aluno aluno = new Aluno();
				aluno.setCodigo(resultSet.getInt("codigo"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setNota_um(resultSet.getInt("nota_um"));
				aluno.setNota_dois(resultSet.getInt("nota_dois"));
				aluno.setNota_tres(resultSet.getInt("nota_tres"));

				// adiciono o contato recuperado, a lista de contatos
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			throw new RuntimeException("erro ao buscar as notas.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		return alunos;
	}

	public void removeById(int idProject) {
		String sql = "DELETE FROM aluno WHERE codigo = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idProject);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("erro ao deletar o aluno.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
}
