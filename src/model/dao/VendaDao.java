
package src.model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.VendaVO;

public class VendaDao<VO extends VendaVO> extends BaseDao<VO> implements VendaInterDao<VO>{

	public void store(VendaVO vo) throws SQLException {
		String sql = "Insert into Venda (precoTotal,dataDeCompra,status,cliente_id) values (?,?,?,?)";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {

			ptst.setFloat(1, vo.getPrecoTotal());
			ptst.setDate(2, new Date(vo.getDataDeCompra().getTimeInMillis()));
			ptst.setString(3, vo.getStatus());
			ptst.setInt(4, vo.getComprador().getId());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void removeById(VendaVO vo) throws SQLException {
		String sql = "Delete from Venda where Id = ?";
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

	public void updateById(VendaVO vo) throws SQLException {
		String sql = "UPDATE Venda SET (precoTotal,dataDeCompra,status,cliente_id) = (?,?,?,?) WHERE id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			ptst.setFloat(1, vo.getPrecoTotal());
			ptst.setDate(2, new Date(vo.getDataDeCompra().getTimeInMillis()));
			ptst.setString(3, vo.getStatus());
			ptst.setInt(4, vo.getComprador().getId());
			ptst.setInt(5, vo.getId());
			

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet index() throws SQLException {
		String sql = "SELECT * FROM Venda";
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
		String sql = "SELECT * FROM Usuario WHERE id =?";
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
	
	public ResultSet findByCliente(VO vo) throws SQLException {
		String sql = "SELECT * FROM Usuario WHERE cliente_id =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getComprador().getId());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet findByDate(VO vo) throws SQLException {
		String sql = "SELECT * FROM Usuario WHERE date =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDate(1, new Date(vo.getDataDeCompra().getTimeInMillis()));

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
