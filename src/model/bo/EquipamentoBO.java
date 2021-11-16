package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.model.dao.EquipamentoDao;
import src.model.vo.EquipamentoVO;
import src.model.vo.FuncionarioVO;
import src.model.vo.LocalVO;

public class EquipamentoBO implements BaseInterBO<EquipamentoVO>, EquipamentoInterBO<EquipamentoVO> {

	EquipamentoDao<EquipamentoVO> dao = new EquipamentoDao<EquipamentoVO>();

	public void store(EquipamentoVO vo) {
		try {
			ResultSet rs = dao.findByCOD(vo);
			if (rs.next()) {

			} else {
				dao.store(vo);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void updateById(EquipamentoVO vo) {
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

	public void removeById(EquipamentoVO vo) {
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

	public EquipamentoVO show(EquipamentoVO vo) {
		ResultSet rs = null;
		EquipamentoVO equiVO = new EquipamentoVO();
		try {
			rs = dao.show(vo);
			while (rs.next()) {
				
				LocalVO local = new LocalVO();
				FuncionarioVO funVO = new FuncionarioVO();

				funVO.setId(rs.getInt("responsavel_id"));
				funVO.setNome(rs.getString("responsavel"));
				
				local.setId(rs.getInt("local_id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento(rs.getString("compartimento"));
				
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("equip_nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));
				
				equiVO.setLocal(local);
				equiVO.setResponsavel(funVO);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return equiVO;
	}

	public List<EquipamentoVO> index() {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			rs = dao.index();
			while (rs.next()) {
				EquipamentoVO equiVO = new EquipamentoVO();
				LocalVO local = new LocalVO();
				FuncionarioVO funVO = new FuncionarioVO();

				funVO.setId(rs.getInt("responsavel_id"));
				funVO.setNome(rs.getString("responsavel"));
				
				local.setId(rs.getInt("local_id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento(rs.getString("compartimento"));
				
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("equip_nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));
				
				equiVO.setLocal(local);
				equiVO.setResponsavel(funVO);
				
				equipamentos.add(equiVO);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return equipamentos;
	}

	public List<EquipamentoVO> findByNome(EquipamentoVO vo) {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			rs = dao.findByNome(vo);
			while (rs.next()) {
				EquipamentoVO equiVO = new EquipamentoVO();
				LocalVO local = new LocalVO();
				FuncionarioVO funVO = new FuncionarioVO();

				funVO.setId(rs.getInt("responsavel_id"));
				funVO.setNome(rs.getString("responsavel"));
				
				local.setId(rs.getInt("local_id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento(rs.getString("compartimento"));
				
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("equip_nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));
				
				equiVO.setLocal(local);
				equiVO.setResponsavel(funVO);
				
				equipamentos.add(equiVO);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return equipamentos;
	}

	public List<EquipamentoVO> findByCOD(EquipamentoVO vo) {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			rs = dao.findByCOD(vo);
			while (rs.next()) {
				EquipamentoVO equiVO = new EquipamentoVO();
				LocalVO local = new LocalVO();
				FuncionarioVO funVO = new FuncionarioVO();

				funVO.setId(rs.getInt("responsavel_id"));
				funVO.setNome(rs.getString("responsavel"));
				
				local.setId(rs.getInt("local_id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento(rs.getString("compartimento"));
				
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("equip_nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));
				
				equiVO.setLocal(local);
				equiVO.setResponsavel(funVO);
				
				equipamentos.add(equiVO);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return equipamentos;
	}

	public List<EquipamentoVO> listByResponsavel(EquipamentoVO vo) {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			rs = dao.listByResponsavel(vo);
			while (rs.next()) {
				EquipamentoVO equiVO = new EquipamentoVO();

				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));

				equipamentos.add(equiVO);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return equipamentos;
	}

	public List<EquipamentoVO> listByLocal(EquipamentoVO vo) {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			rs = dao.listByLocal(vo);
			while (rs.next()) {
				EquipamentoVO equiVO = new EquipamentoVO();

				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));

				equipamentos.add(equiVO);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return equipamentos;
	}

	@Override
	public Integer quantidadeEstoque() throws SQLException {
		ResultSet rs = null;
		int quantidade = 0;
		try {
			rs = dao.quantidadeEstoque();
			while (rs.next()) {
				quantidade = rs.getInt("sum");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}

	@Override
	public String EquipamentoMaisVendido() throws SQLException {
		ResultSet rs = null;
		String equipamento =" ";
		try {
			rs = dao.EquipamentoMaisVendido();
			while (rs.next()) {
				equipamento = rs.getString("max");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return equipamento;
	}

	@Override
	public Integer TotalEquipamentosVendidos() throws SQLException {
		ResultSet rs = null;
		int quantidade = 0;
		try {
			rs = dao.TotalEquipamentosVendidos();
			while (rs.next()) {

				quantidade = rs.getInt("qtd");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}

}
