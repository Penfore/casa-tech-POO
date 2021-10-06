package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.dao.EquipamentoDao;
import src.model.vo.EquipamentoVO;

public class EquipamentoBO implements BaseInterBO<EquipamentoVO>, EquipamentoInterBO<EquipamentoVO> {

	EquipamentoDao<EquipamentoVO> dao = new EquipamentoDao<EquipamentoVO>();

	public void store(EquipamentoVO vo){
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

	public void updateById(EquipamentoVO vo)  {
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

	public void removeById(EquipamentoVO vo){
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

	public void show(EquipamentoVO vo){
		try {
			dao.show(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void index()  {
		try {
			dao.index();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
	public void findByNome(EquipamentoVO vo)  {
		try {
			dao.findByNome(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
	public void findByCOD(EquipamentoVO vo)  {
		try {
			dao.findByCOD(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void listByResponsavel(EquipamentoVO vo)  {
		try {
			dao.listByResponsavel(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public void listByLocal(EquipamentoVO vo)  {
		try {
			dao.listByLocal(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
