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
				throw new SQLException(" A inserção falhou :( ");
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
				throw new SQLException(" A inserção falhou :( ");
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
		
		String sql = "SELECT "
				+ "equipamento.id,equipamento.nome as equip_nome,peso,codigo,quantidade, "
				+ "descricao,responsavel_id,local_id,preco,casa,compartimento, "
				+ "funcionario.nome as responsavel "
				+ "FROM Equipamento "
				+ "Inner JOIN local ON local.id = Equipamento.local_id "
				+ "Inner JOIN funcionario ON funcionario.id = Equipamento.responsavel_id";
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
		String sql = "SELECT "
				+ "equipamento.id,equipamento.nome as equip_nome,peso,codigo,quantidade, "
				+ "descricao,responsavel_id,local_id,preco,casa,compartimento, "
				+ "funcionario.nome as responsavel "
				+ "FROM Equipamento "
				+ "Inner JOIN local ON local.id = Equipamento.local_id "
				+ "Inner JOIN funcionario ON funcionario.id = Equipamento.responsavel_id "
				+ "WHERE Equipamento.id = ?";
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
		String sql = "SELECT "
				+ "equipamento.id,equipamento.nome as equip_nome,peso,codigo,quantidade, "
				+ "descricao,responsavel_id,local_id,preco,casa,compartimento, "
				+ "funcionario.nome as responsavel "
				+ "FROM Equipamento "
				+ "Inner JOIN local ON local.id = Equipamento.local_id "
				+ "Inner JOIN funcionario ON funcionario.id = Equipamento.responsavel_id "
				+ "WHERE Equipamento.nome = ?";
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
		String sql = "SELECT "
				+ "equipamento.id,equipamento.nome as equip_nome,peso,codigo,quantidade, "
				+ "descricao,responsavel_id,local_id,preco,casa,compartimento, "
				+ "funcionario.nome as responsavel "
				+ "FROM Equipamento "
				+ "Inner JOIN local ON local.id = Equipamento.local_id "
				+ "Inner JOIN funcionario ON funcionario.id = Equipamento.responsavel_id "
				+ "WHERE Equipamento.codigo = ?";
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
		String sql = "SELECT "
				+ "equipamento.id,equipamento.nome as equip_nome,peso,codigo,quantidade, "
				+ "descricao,responsavel_id,local_id,preco,casa,compartimento, "
				+ "funcionario.nome as responsavel "
				+ "FROM Equipamento "
				+ "Inner JOIN local ON local.id = Equipamento.local_id "
				+ "Inner JOIN funcionario ON funcionario.id = Equipamento.responsavel_id "
				+ "WHERE funcionario.nome = ?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getResponsavel().getNome());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listByLocal(VO vo) throws SQLException {
		String sql = "SELECT "
				+ "equipamento.id,equipamento.nome as equip_nome,peso,codigo,quantidade, "
				+ "descricao,responsavel_id,local_id,preco,casa,compartimento, "
				+ "funcionario.nome as responsavel "
				+ "FROM Equipamento "
				+ "Inner JOIN local ON local.id = Equipamento.local_id "
				+ "Inner JOIN funcionario ON funcionario.id = Equipamento.responsavel_id "
				+ "WHERE local.casa = ? OR local.compartimento = ?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getLocal().getCasa());
			ptst.setString(2, vo.getLocal().getCompartimento());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet quantidadeEstoque() throws SQLException {
		String sql = "Select SUM(quantidade) from equipamento";
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
	
	public ResultSet TotalEquipamentosVendidos() throws SQLException {
		String sql = "SELECT (a.c * b.d) AS qtd "
				+ "FROM (SELECT COUNT(*)  AS c FROM carrinho)AS a, "
				+ "	 (SELECT SUM(quantidade)  AS d from carrinho)As b ";
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
	
	
	public ResultSet EquipamentoMaisVendido() throws SQLException {
		String sql = "SELECT MAX(nome) as max FROM (SELECT nome,equipamento_id, count(*) "
				+ "FROM carrinho JOIN equipamento ON equipamento.id = equipamento_id "
				+ "GROUP BY equipamento_id, nome )as pg";
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
