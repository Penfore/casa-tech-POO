package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.CarrinhoVO;
import src.model.vo.EquipamentoVO;
import src.model.vo.VendaVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CarrinhoDao extends BaseDao {

	public void inserir(CarrinhoVO vo) throws SQLException {
		conn = getConnection();
		String sql = "Insert into Carrinho (venda_id,equipamento_id,quantidade) values (?,?,?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setInt(1, vo.getVenda().getId());
			ptst.setInt(2,vo.getProduto().getId());
			ptst.setInt(3,vo.getQuantidade());
			ptst.execute();
		} catch (SQLException e) {

		}
	}

	public void removeById(CarrinhoVO vo) throws SQLException {
		conn = getConnection();
		String sql = "DELETE FROM Carrinho WHERE venda_id = ? AND equipamento_id = ? ";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {

			ptst.setInt(1, vo.getVenda().getId());
			ptst.setInt(2, vo.getProduto().getId());
			ptst.execute();

		} catch (SQLException e) {

		}
	}

	public void updateById(CarrinhoVO vo) throws SQLException {
		conn = getConnection();
		String sql = "UPDATE  Carrinho SET (quantidade) = ? WHERE venda_id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {

			ptst.setInt(1, vo.getVenda().getId());
			ptst.setInt(2,vo.getProduto().getId());
			ptst.setInt(3,vo.getQuantidade());
			ptst.execute();

		} catch (SQLException e) {

		}
	}

	public List<CarrinhoVO> index() throws SQLException {
		conn = getConnection();
		String sql = "SELECT * FROM Carrinho a";
		Statement st;
		ResultSet rs;
		List<CarrinhoVO> carrinho = new ArrayList<CarrinhoVO>();

		try {

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				CarrinhoVO carrinhoVO = new CarrinhoVO();
				VendaVO vendaVO = new VendaVO();
				EquipamentoVO equiVO = new EquipamentoVO();
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("dataDeCompra"));
				
				equiVO.setId(rs.getInt("equipamento_id"));
				equiVO.setNome(rs.getString("nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));	
				equiVO.setPreco(rs.getDouble("preco"));

				vendaVO.setPrecoTotal(rs.getFloat("precoTotal"));
				vendaVO.setDataDeCompra(calendar);// TRANSFORMAR ISSO EM DATETIME NO BANCO
				vendaVO.setStatus(rs.getString("Status"));
				vendaVO.setId(rs.getInt("venda_id"));
				
				carrinhoVO.setVenda(vendaVO);
				carrinhoVO.setProduto(equiVO);
				carrinhoVO.setQuantidade(rs.getInt("quantidade"));
				
			
				carrinho.add(carrinhoVO);

			}
		} catch (SQLException e) {

		}
		return carrinho;
	}

}
