package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.ClienteVO;

public class ClienteDao<VO extends ClienteVO> extends BaseDao<VO> implements ClienteInterDao<VO> {

	public void store(ClienteVO vo) throws SQLException {
		String sql = "Insert into Cliente (nome,endereco,email,telefone,cpf) values (?,?,?,?,?)";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getEmail());
			ptst.setString(4, vo.getTelefone());
			ptst.setString(5, vo.getCpf());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A update falhou :( ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void removeById(ClienteVO vo) throws SQLException {
		String sql = "Delete from Cliente where Id = ?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			ptst.setInt(1, vo.getId());
			
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inser��o falhou :( ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateById(ClienteVO vo) throws SQLException {

		String sql = "UPDATE Cliente SET nome = ?,endereco= ?,email= ?,telefone= ?,cpf= ? WHERE id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {

			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getEmail());
			ptst.setString(4, vo.getTelefone());
			ptst.setString(5, vo.getCpf());
			ptst.setInt(6, vo.getId());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inser��o falhou :( ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet index() throws SQLException {

		String sql = "SELECT * FROM Cliente";
		Statement st;
		ResultSet rs = null;

		try {

			st = getConnection().createStatement();
			rs = st.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet show(VO vo) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE id =?";
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
	
	public ResultSet findByCPF(VO vo) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE cpf = ?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getCpf());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet findByNome(VO vo) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE nome = ?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet quantidadeClientes() throws SQLException {
		String sql = "SELECT COUNT(*) FROM cliente";
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