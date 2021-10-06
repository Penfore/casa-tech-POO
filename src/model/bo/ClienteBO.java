package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.dao.ClienteDao;
import src.model.vo.ClienteVO;

public class ClienteBO implements BaseInterBO<ClienteVO>, ClienteInterBO<ClienteVO> {


	ClienteDao<ClienteVO> dao = new ClienteDao<ClienteVO>();

	public void store(ClienteVO vo){
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

	public void updateById(ClienteVO vo)  {
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

	public void removeById(ClienteVO vo){
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

	public void show(ClienteVO vo){
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
	
	public void findByCPF(ClienteVO vo)  {
		try {
			dao.findByCPF(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
	public void findByNome(ClienteVO vo)  {
		try {
			dao.findByNome(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}
