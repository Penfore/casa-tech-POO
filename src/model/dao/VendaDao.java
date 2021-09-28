
package src.model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import src.model.vo.VendaVO;
import src.model.vo.ClienteVO;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class VendaDao extends BaseDao {

	public void inserir(VendaVO vo) throws SQLException {
		conn = getConnection();
		String sql = "Insert into Venda (precoTotal,dataDeCompra,status,cliente_id) values (?,?,?,?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			
			ptst.setFloat(1, vo.getPrecoTotal());
			ptst.setDate(2, new Date(vo.getDataDeCompra().getTimeInMillis()));
			ptst.setString(3, vo.getStatus());
			ptst.setInt(4, vo.getComprador().getId());
			ptst.execute();
		} catch (SQLException e) {

		}

	}

	public void RemoveById(VendaVO vo) throws SQLException {
		conn = getConnection();
		String sql = "Delete from Venda where Id = ?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setInt(1, vo.getId());
			ptst.execute();

		} catch (SQLException e) {

		}
	}

	public void updateById(VendaVO vo) throws SQLException {
		conn = getConnection();
		String sql = "UPDATE Venda SET (precoTotal,dataDeCompra,status,cliente_id) = (?,?,?,?) WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setFloat(1, vo.getPrecoTotal());
			ptst.setDate(2, new Date(vo.getDataDeCompra().getTimeInMillis()));
			ptst.setString(3, vo.getStatus());
			ptst.setInt(4, vo.getComprador().getId());
			
			ptst.setInt(5, vo.getId());

			ptst.execute();
		} catch (SQLException e) {

		}
	}

	public List<VendaVO> index() throws SQLException {
		conn = getConnection();
		String sql = "SELECT * FROM Venda";
		Statement st;
		ResultSet rs;
		List<VendaVO> vendas = new ArrayList<VendaVO>();
		try {

			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				VendaVO vendaVO = new VendaVO();
				ClienteVO cliVO = new ClienteVO();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("dataDeCompra"));

				
				cliVO.setId(rs.getInt("cliente_id"));
				cliVO.setNome(rs.getString("nome"));
				cliVO.setRua(rs.getString("rua"));
				cliVO.setBairro(rs.getString("bairro"));
				cliVO.setEmail(rs.getString("email"));
				cliVO.setTelefone(rs.getString("telefone"));
				cliVO.setCep(rs.getString("cep"));
				cliVO.setCpf(rs.getString("cpf"));

				vendaVO.setId(rs.getInt("id"));
				vendaVO.setPrecoTotal(rs.getFloat("precoTotal"));
				vendaVO.setDataDeCompra(calendar);// TRANSFORMAR ISSO EM DATETIME NO BANCO
				vendaVO.setStatus(rs.getString("Status"));
				vendaVO.setComprador(cliVO);
				
				vendas.add(vendaVO);

			}
		} catch (SQLException e) {

		}
		return vendas;
	}
}
