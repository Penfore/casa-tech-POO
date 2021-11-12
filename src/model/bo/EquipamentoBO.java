package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.model.dao.EquipamentoDao;
import src.model.vo.EquipamentoVO;

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

	public void show(EquipamentoVO vo) {
		try {
			dao.show(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public List<EquipamentoVO> index() {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			rs = dao.index();
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

	public List<EquipamentoVO> findByNome(EquipamentoVO vo) {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			dao.findByNome(vo);
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

	public List<EquipamentoVO> findByCOD(EquipamentoVO vo) {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			dao.findByCOD(vo);
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

	public List<EquipamentoVO> listByResponsavel(EquipamentoVO vo) {
		ResultSet rs = null;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		try {
			dao.listByResponsavel(vo);
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
			dao.listByLocal(vo);
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

}
