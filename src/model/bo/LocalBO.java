package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;


import src.model.dao.LocalDao;

import src.model.vo.LocalVO;

public class LocalBO implements BaseInterBO<LocalVO>, LocalInterBO<LocalVO> {
	LocalDao<LocalVO> dao = new LocalDao<LocalVO>();

	public void store(LocalVO vo){
		try {
			ResultSet rs = dao.findByCasa(vo);
			if (rs.next()) {

			} else {
				dao.store(vo);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void updateById(LocalVO vo)  {
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

	public void removeById(LocalVO vo){
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

	public void show(LocalVO vo){
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
	
	public void findByCasa(LocalVO vo)  {
		try {
			dao.findByCasa(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
	public void listByCompartimento(LocalVO vo)  {
		try {
			dao.listByCompartimento(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
