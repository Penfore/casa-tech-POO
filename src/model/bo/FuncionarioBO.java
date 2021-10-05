package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.dao.FuncionarioDao;
import src.model.dao.UsuarioDao;
import src.model.vo.FuncionarioVO;


public class FuncionarioBO implements BaseInterBO<FuncionarioVO>, FuncionarioInterBO<FuncionarioVO> {
	UsuarioDao<FuncionarioVO> dao = new FuncionarioDao();
	FuncionarioDao fundao = new FuncionarioDao();
	public void store(FuncionarioVO vo){
		try {
			ResultSet rs = dao.findByNickName(vo);
			if (rs.next()) {

			} else {
				dao.store(vo);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void updateById(FuncionarioVO vo)  {
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

	public void removeById(FuncionarioVO vo){
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

	public void show(FuncionarioVO vo){
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
	
	public void findByEmail(FuncionarioVO vo)  {
		try {
			fundao.findByEmail(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
	public void listByCargo(FuncionarioVO vo)  {
		try {
			fundao.listByCargo(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
}
