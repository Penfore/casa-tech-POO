
package src.model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;

import src.model.vo.VendaVO;
import src.view.TelasPrincipal;


public class VendaDao<VO extends VendaVO> extends BaseDao<VO> implements VendaInterDao<VO>{

	public void store(VendaVO vo) throws SQLException {
		String sql = "Insert into Venda (precoTotal,dataDeCompra,status,formadepagamento,cliente_id) values (?,?,?,?,?)";
		PreparedStatement ptst = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		try {
			
			ptst.setFloat(1, 0);
			ptst.setDate(2, new Date(vo.getDataDeCompra().getTimeInMillis()));
			ptst.setString(3, "ABERTO");
			ptst.setString(4, "DINHEIRO");
			ptst.setInt(5, vo.getComprador().getId());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0) {
				throw new SQLException(" A inser??o falhou :( ");
			}
				ResultSet generatedKeys = ptst.getGeneratedKeys();
				if (generatedKeys.next()) {
					vo.setId(generatedKeys.getInt(1));
				}
				TelasPrincipal.setVenda(vo);
				System.out.println("deu certo :)");
			
			
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
				throw new SQLException(" A inser??o falhou :( ");
			}else {
				System.out.println("deu certo:)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateById(VendaVO vo) throws SQLException {
		String sql = "UPDATE Venda SET precoTotal = ?,status = ?,formadepagamento = ? "
				+ "WHERE id = ?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {
			ptst.setFloat(1, vo.getPrecoTotal());
			ptst.setString(2, vo.getStatus());
			ptst.setString(3, vo.getFormaDePagamento());
			ptst.setInt(4, vo.getId());
			System.out.println(ptst);

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inser??o falhou :( ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet index() throws SQLException {
		String sql = "SELECT venda.*,cliente.nome as comprador, "
				+ "cliente.endereco, cliente.email, cliente.telefone, cliente.cpf "
				+ "FROM Venda "
				+ "Inner Join cliente ON casatech.Venda.cliente_id = cliente.id";
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
		String sql = "SELECT venda.id, precototal,datadecompra,status,formadepagamento,cliente_id,cliente.nome as comprador "
				+ "FROM Venda "
				+ "Inner Join cliente ON Venda.cliente_id = cliente.id WHERE venda.id = ?";
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
		String sql = "SELECT venda.*, cliente.nome as comprador FROM venda INNER JOIN cliente ON "
				+ "venda.cliente_id = cliente.id "
				+ "WHERE cliente.nome = ? ";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getComprador().getNome());
			System.out.println(ptst);

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet findByDate(VO vo) throws SQLException {
		String sql = "SELECT * FROM Venda WHERE datadecompra = ?";
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
	
	public ResultSet vendasFinalizadas() throws SQLException {
		String sql = "SELECT COUNT(*) FROM Venda Where status = 'FINALIZADO'";
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
	public ResultSet vendasCanceladas() throws SQLException {
		String sql = "SELECT COUNT(*) FROM Venda Where status = 'CANCELADO'";
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
	public ResultSet totalVendas() throws SQLException {
		String sql = "SELECT COUNT(*) FROM Venda ";
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
	public ResultSet vendasDoMes() throws SQLException {
		String sql = "Select COUNT(*) from venda Where status = 'FINALIZADO' AND dataDeCompra "
				+    "BETWEEN ? AND ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		
		YearMonth yearMonth = YearMonth.of( year,month+1); 
		LocalDate firstOfMonth = yearMonth.atDay( 1 );
		LocalDate last = yearMonth.atEndOfMonth();
		Date firstDate = Date.valueOf(firstOfMonth);
		Date lastDate =  Date.valueOf(last);

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDate(1, firstDate);
			ptst.setDate(2, lastDate);
			rs = ptst.executeQuery();
			System.out.println(ptst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet TotalPrecoVendido() throws SQLException {
		String sql = "Select SUM(precoTotal) As capital from venda Where status = 'FINALIZADO'";
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
	public ResultSet PagamentoMaisUsado() throws SQLException {
		String sql = "SELECT Max(cont),Max(formadepagamento) as pagamento FROM( "
				+ "SELECT formadepagamento, count(*) as cont "
				+ "FROM venda GROUP BY formadepagamento ORDER BY cont DESC FETCH FIRST 1 ROWS WITH TIES) as pg GROUP BY formadepagamento,cont";
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
