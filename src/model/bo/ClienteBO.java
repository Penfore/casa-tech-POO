package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.model.dao.ClienteDao;
import src.model.vo.ClienteVO;

public class ClienteBO implements BaseInterBO<ClienteVO>, ClienteInterBO<ClienteVO> {

	ClienteDao<ClienteVO> dao = new ClienteDao<ClienteVO>();

	public void store(ClienteVO vo) {
		try {
			ResultSet rs = dao.findByCPF(vo);
			if (rs.next()) {

			} else {
				dao.store(vo);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void updateById(ClienteVO vo) {
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

	public void removeById(ClienteVO vo) {
		try {
			ResultSet rs = dao.show(vo);
			if (rs.next()) {
				dao.removeById(vo);
			} else {

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public ClienteVO show(ClienteVO vo) {
		ResultSet rs = null;
		ClienteVO comprador = new ClienteVO();
		try {
			rs = dao.show(vo);
			while (rs.next()) {
				comprador.setId(rs.getInt("id"));
				comprador.setNome(rs.getString("nome"));
				comprador.setCpf(rs.getString("cpf"));
				comprador.setEndereco(rs.getString("endereco"));
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return comprador;
	}

	public List<ClienteVO> index() {
		ResultSet rs = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			rs = dao.index();
			while (rs.next()) {
				ClienteVO comprador = new ClienteVO();
				comprador.setId(rs.getInt("id"));
				comprador.setNome(rs.getString("nome"));
				comprador.setCpf(rs.getString("cpf"));
				comprador.setEndereco(rs.getString("endereco"));
				comprador.setEmail(rs.getString("email"));
				clientes.add(comprador);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return clientes;
	}

	public List<ClienteVO> findByCPF(ClienteVO vo) {
		ResultSet rs = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			rs = dao.findByCPF(vo);
			while (rs.next()) {
				ClienteVO comprador = new ClienteVO();
				comprador.setId(rs.getInt("id"));
				comprador.setNome(rs.getString("nome"));
				comprador.setCpf(rs.getString("cpf"));
				comprador.setEndereco(rs.getString("endereco"));
				clientes.add(comprador);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return clientes;

	}

	public List<ClienteVO> findByNome(ClienteVO vo) {
		ResultSet rs = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			rs = dao.findByNome(vo);
			while (rs.next()) {
				ClienteVO comprador = new ClienteVO();
				comprador.setId(rs.getInt("id"));
				comprador.setNome(rs.getString("nome"));
				comprador.setCpf(rs.getString("cpf"));
				comprador.setEndereco(rs.getString("endereco"));
				clientes.add(comprador);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return clientes;
	}
	public Integer quantidadeClientes() throws SQLException {
		ResultSet rs = null;
		int quantidade = 0;
		try {
			rs = dao.quantidadeClientes();
			while (rs.next()) {
				quantidade = rs.getInt("count");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}
}
