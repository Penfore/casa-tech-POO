package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.LocalVO;



public class LocalDao<VO extends LocalVO> extends BaseDao<VO> implements LocalInterDao<VO>{

	public void store(VO vo) throws SQLException {

		String sql = "Insert into Local (casa,compartimento) values (?,?)";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			ptst.setString(1, vo.getCasa());
			ptst.setString(2, vo.getCompartimento());
			
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void removeById(VO vo) throws SQLException{
		String sql = "Delete from Local where Id = ?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			ptst.setInt(1, vo.getId());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateById(VO vo) throws SQLException {
		String sql = "UPDATE Local SET casa = ?,compartimento = ? WHERE id = ?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {

			ptst.setString(1, vo.getCasa());
			ptst.setString(2, vo.getCompartimento());
			ptst.setInt(3, vo.getId());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet index() throws SQLException {
		String sql = "SELECT * FROM Local";
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
		String sql = "SELECT * FROM Local WHERE id =?";
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
	
	public ResultSet findByCasa(VO vo) throws SQLException {
		String sql = "SELECT * FROM Local WHERE casa =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getCasa());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listByCompartimento(VO vo) throws SQLException {
		String sql = "SELECT * FROM Local WHERE compartimento =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getCompartimento());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}