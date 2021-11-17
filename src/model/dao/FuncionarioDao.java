package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.FuncionarioVO;

public class FuncionarioDao extends UsuarioDao<FuncionarioVO> implements FuncionarioInterDao<FuncionarioVO>{
	public void store(FuncionarioVO vo) throws SQLException {

		super.store(vo);

		String sql = "Insert into Funcionario (nome,endereco,email,telefone,cargo,usuario_id) values (?,?,?,?,?,?)";
		PreparedStatement ptst = getConnection().prepareStatement(sql);

		try {
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getEmail());
			ptst.setString(4, vo.getTelefone());
			ptst.setInt(5, vo.getCargo());
			ptst.setInt(6, vo.getUsuid());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}

			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				vo.setId(generatedKeys.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void removeById(FuncionarioVO vo) throws SQLException {
		super.removeById(vo);
		String sql = "DELETE FROM Funcionario WHERE id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);

		try {
			ptst.setInt(1, vo.getId());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void updateById(FuncionarioVO vo) throws SQLException {
		super.updateById(vo);
		String sql = "UPDATE  Funcionario SET nome = ?,endereco = ? ,email = ?,telefone = ?,cargo = ?  WHERE id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			super.updateById(vo);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getEmail());
			ptst.setString(4, vo.getTelefone());
			ptst.setInt(5, vo.getCargo());
			ptst.setInt(6, vo.getId());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("O update falhou :( ");
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public ResultSet index() throws SQLException {

		String sql = "SELECT * FROM Funcionario Inner Join Usuario ON Funcionario.usuario_id = "
				+ "Usuario.id";
		Statement st;
		ResultSet rs = null;

		try {

			st = getConnection().createStatement();
			rs = st.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println(e);
		}
		return rs;
	}

	public ResultSet show(FuncionarioVO vo) throws SQLException {
		String sql = "SELECT * FROM Funcionario WHERE id =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getId());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet findByEmail(FuncionarioVO vo) throws SQLException {
		String sql = "SELECT * FROM Funcionario WHERE email =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getEmail());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listByCargo(FuncionarioVO vo) throws SQLException {
		String sql = "SELECT * FROM Funcionario WHERE cargo =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCargo());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}


	public ResultSet quantidadeFuncionarios() throws SQLException {
		String sql = "SELECT COUNT(*) FROM Funcionario";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
