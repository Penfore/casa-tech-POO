package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.dao.VendaDao;
import src.model.vo.VendaVO;

public class VendaBO implements BaseInterBO<VendaVO>, VendaInterBO<VendaVO> {
	VendaDao<VendaVO> dao = new VendaDao<VendaVO>();

	public void store(VendaVO vo) {
		try {
//QUAL A REGRA DE NEGOCIO AQ?
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
			} else {

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void show(VendaVO vo) {
		try {
			dao.show(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void index() {
		try {
			dao.index();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void findByCliente(VendaVO vo) {
		try {
			dao.findByCliente(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void findByDate(VendaVO vo) {
		try {
			dao.findByDate(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
