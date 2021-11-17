package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import src.model.dao.VendaDao;
import src.model.vo.ClienteVO;
import src.model.vo.VendaVO;
import src.view.TelasPrincipal;

public class VendaBO implements BaseInterBO<VendaVO>, VendaInterBO<VendaVO> {
	VendaDao<VendaVO> dao = new VendaDao<VendaVO>();

	public void store(VendaVO vo) {
		try {
			vo.setDataDeCompra(Calendar.getInstance());
			dao.store(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void updateById(VendaVO vo) {
		try {
			ResultSet rs = dao.show(vo);
			if (rs.next()) {
				dao.updateById(vo);
			} else {

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void removeById(VendaVO vo) {
		try {
			ResultSet rs = dao.show(vo);
			if (rs.next()) {
				dao.removeById(vo);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public VendaVO show(VendaVO vo) {
		ResultSet rs = null;
		VendaVO venda = new VendaVO();
		try {
			rs = dao.show(vo);
			while (rs.next()) {

				ClienteVO comprador = new ClienteVO();
				comprador.setNome(rs.getString("comprador"));

				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("datadecompra"));

				venda.setDataDeCompra(cal);
				venda.setId(rs.getInt("id"));
				venda.setPrecoTotal(rs.getFloat("precoTotal"));
				venda.setStatus(rs.getString("status"));
				venda.setFormaDePagamento(rs.getString("formaDePagamento"));
				venda.setComprador(comprador);

			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return venda;
	}

	public List<VendaVO> index() {
		ResultSet rs = null;
		List<VendaVO> vendas = new ArrayList<VendaVO>();
		try {
			rs = dao.index();
			while (rs.next()) {
				VendaVO venda = new VendaVO();
				
				ClienteVO comprador = new ClienteVO();
				comprador.setNome(rs.getString("comprador"));
				comprador.setEmail(rs.getString("email"));
				comprador.setTelefone(rs.getString("telefone"));
				comprador.setCpf(rs.getString("cpf"));
				comprador.setEndereco(rs.getString("endereco"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("datadecompra"));

				venda.setDataDeCompra(cal);
				venda.setId(rs.getInt("id"));
				venda.setPrecoTotal(rs.getFloat("precoTotal"));
				venda.setStatus(rs.getString("status"));
				venda.setFormaDePagamento(rs.getString("formaDePagamento"));
				venda.setComprador(comprador);

				vendas.add(venda);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vendas;
	}

	public List<VendaVO> findByCliente(VendaVO vo) {
		ResultSet rs = null;
		List<VendaVO> vendas = new ArrayList<VendaVO>();
		try {
			
			rs = dao.findByCliente(vo);
			while (rs.next()) {
				VendaVO venda = new VendaVO();
				ClienteVO comprador = new ClienteVO();
				
				comprador.setNome(rs.getString("comprador"));
				
				venda.setId(rs.getInt("id"));
				venda.setPrecoTotal(rs.getFloat("precoTotal"));

				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("datadecompra"));
				venda.setDataDeCompra(cal);

				venda.setStatus(rs.getString("status"));
				venda.setComprador(comprador);
				vendas.add(venda);

			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vendas;
	}

	public List<VendaVO> findByDate(VendaVO vo) {
		ResultSet rs = null;
		List<VendaVO> vendas = new ArrayList<VendaVO>();
		try {
			rs = dao.findByDate(vo);
			while (rs.next()) {
				VendaVO venda = new VendaVO();
				ClienteVO comprador = new ClienteVO();
				comprador.setNome(rs.getString("comprador"));

				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("datadecompra"));

				venda.setDataDeCompra(cal);
				venda.setId(rs.getInt("id"));
				venda.setPrecoTotal(rs.getFloat("precoTotal"));
				venda.setStatus(rs.getString("status"));
				venda.setFormaDePagamento(rs.getString("formaDePagamento"));
				venda.setComprador(comprador);

				vendas.add(venda);

			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return vendas;
	}

	@Override
	public Integer totalVendas() throws SQLException {
		ResultSet rs = null;
		int quantidade = 0;
		try {
			rs = dao.totalVendas();
			while (rs.next()) {
				quantidade = rs.getInt("count");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}

	@Override
	public Integer vendasFinalizadas() throws SQLException {
		ResultSet rs = null;
		int quantidade = 0;
		try {
			rs = dao.vendasFinalizadas();
			while (rs.next()) {
				quantidade = rs.getInt("count");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}

	@Override
	public Integer vendasCanceladas() throws SQLException {
		ResultSet rs = null;
		int quantidade = 0;
		try {
			rs = dao.vendasCanceladas();
			while (rs.next()) {
				quantidade = rs.getInt("count");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}

	@Override
	public Integer vendasDoMes() throws SQLException {
		ResultSet rs = null;
		int quantidade = 0;
		try {
			rs = dao.vendasDoMes();
			while (rs.next()) {
				quantidade = rs.getInt("count");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}

	@Override
	public Float TotalPrecoVendido() throws SQLException {
		ResultSet rs = null;
		float quantidade = 0;
		try {
			rs = dao.TotalPrecoVendido();
			while (rs.next()) {
				quantidade = rs.getInt("capital");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}

	@Override
	public String PagamentoMaisUsado() throws SQLException {
		ResultSet rs = null;
		String pagamento = " ";
		try {
			rs = dao.PagamentoMaisUsado();
			while (rs.next()) {
				pagamento = rs.getString("pagamento");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return pagamento;
	}
}
