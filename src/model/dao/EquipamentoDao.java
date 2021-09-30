package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.EquipamentoVO;

public class EquipamentoDao<VO extends EquipamentoVO> extends BaseDao<VO> implements EquipamentoInterDao<VO>{

	public void store(EquipamentoVO vo) throws SQLException {
		String sql = "Insert into Equipamento "
				+ "(nome,peso,codigo,quantidade,descricao,preco,responsavel_id,local_id) "
				+ "values (?,?,?,?,?,?,?,?)";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		
		try {
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPeso());
			ptst.setString(3,vo.getCodigo());
			ptst.setInt(4,vo.getQuantidade());
			ptst.setString(5,vo.getDescricao());
			ptst.setDouble(6,vo.getPreco());
			ptst.setInt(7,vo.getResponsavel().getId());
			ptst.setInt(8,vo.getLocal().getId());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inser��o falhou :( ");
			}
			
		}catch( SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeById(EquipamentoVO vo) throws SQLException  {
		String sql = "DELETE FROM Equipamento WHERE id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {

			ptst.setInt(1,vo.getId());
			
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inser��o falhou :( ");
			}

			
		}catch( SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateById(EquipamentoVO vo) throws SQLException  {
		String sql = "UPDATE  Equipamento SET "
				+ "(nome,peso,codigo,quantidade,descricao,preco,responsavel_id,local_id) = "
				+ "(?,?,?,?,?,?,?,?) WHERE id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPeso());
			ptst.setString(3,vo.getCodigo());
			ptst.setInt(4,vo.getQuantidade());
			ptst.setString(5,vo.getDescricao());
			ptst.setDouble(6,vo.getPreco());
			ptst.setInt(7,vo.getResponsavel().getId());
			ptst.setInt(8,vo.getLocal().getId());
			ptst.setInt(9,vo.getId());
			
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A update falhou :( ");
			}

			
		}catch( SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet index() throws SQLException{
		
		String sql = "SELECT * FROM Equipamento ";
		Statement st;
		ResultSet rs= null;
		
		try {
			
			st = getConnection().createStatement(); 
			rs = st.executeQuery(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet show(VO vo) throws SQLException {
		String sql = "SELECT * FROM Equipamento WHERE id =?";
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
	
	public ResultSet findByNome(VO vo) throws SQLException {
		String sql = "SELECT * FROM Equipamento WHERE nome =?";
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
	
	public ResultSet findByCOD(VO vo) throws SQLException {
		String sql = "SELECT * FROM Equipamento WHERE codigo =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getCodigo());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listByResponsavel(VO vo) throws SQLException {
		String sql = "SELECT * FROM Equipamento WHERE responssavel_id =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getResponsavel().getId());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listByLocal(VO vo) throws SQLException {
		String sql = "SELECT * FROM Equipamento WHERE id =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getLocal().getId());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
