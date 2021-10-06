package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.CarrinhoVO;

public class CarrinhoDao<VO extends CarrinhoVO> extends BaseDao<VO> implements CarrinhoInterDao<VO> {

	public void store(CarrinhoVO vo) throws SQLException {
		String sql = "Insert into Carrinho (venda_id,equipamento_id,quantidade) values (?,?,?)";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			ptst.setInt(1, vo.getVenda().getId());
			ptst.setInt(2,vo.getProduto().getId());
			ptst.setInt(3,vo.getQuantidade());
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}
		} catch (SQLException e) {

		}
	}

	public void removeById(CarrinhoVO vo) throws SQLException {
		String sql = "DELETE FROM Carrinho WHERE venda_id = ? AND equipamento_id = ? ";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {

			ptst.setInt(1, vo.getVenda().getId());
			ptst.setInt(2, vo.getProduto().getId());
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}

		} catch (SQLException e) {

		}
	}

	public void updateById(CarrinhoVO vo) throws SQLException {
		String sql = "UPDATE  Carrinho SET (quantidade) = ? WHERE venda_id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {

			ptst.setInt(1, vo.getVenda().getId());
			ptst.setInt(2,vo.getProduto().getId());
			ptst.setInt(3,vo.getQuantidade());
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}

		} catch (SQLException e) {

		}
	}

	public ResultSet index() throws SQLException {
		String sql = "SELECT * FROM Carrinho ";
		Statement st;
		ResultSet rs = null;
		try {

			st = getConnection().createStatement();
			rs = st.executeQuery(sql);

		} catch (SQLException e) {

		}
		return rs;
	}
	
	public ResultSet show(VO vo) throws SQLException {
		String sql = "SELECT * FROM Carrinho WHERE venda_id =? AND equipamento_id=?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getVenda().getId());
			ptst.setInt(2, vo.getProduto().getId());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listByVenda(VO vo) throws SQLException {
		String sql = "SELECT * FROM Carrinho WHERE venda_id =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getVenda().getId());


			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listByProduto(VO vo) throws SQLException {
		String sql = "SELECT * FROM Carrinho WHERE equipamento_id=?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getProduto().getId());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listByProdutoVenda(VO vo) throws SQLException {
		String sql = "SELECT * FROM Carrinho WHERE equipamento_id=? AND venda_id =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getProduto().getId());
			ptst.setInt(2, vo.getVenda().getId());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
