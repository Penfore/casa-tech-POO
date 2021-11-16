package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public LocalVO show(LocalVO vo){
		ResultSet rs = null;
		LocalVO local = new LocalVO();
		try {
			rs = dao.show(vo);
			while (rs.next()) {
				local.setId(rs.getInt("id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento(rs.getString("compartimento"));
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return local;

	}

	public List<LocalVO> index()  {
		ResultSet rs = null;
		List<LocalVO> locais = new ArrayList<LocalVO>();
		try {
			rs = dao.index();
			while(rs.next()){
				LocalVO local = new LocalVO();
				
				local.setId(rs.getInt("id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento(rs.getString("compartimento"));
				
				locais.add(local);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return locais;

	}
	
	public List<LocalVO> findByCasa(LocalVO vo)  {
		ResultSet rs = null;
		List<LocalVO> locais = new ArrayList<LocalVO>();
		try {
			rs = dao.findByCasa(vo);
			while(rs.next()){
				LocalVO local = new LocalVO();
				
				local.setId(rs.getInt("id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento(rs.getString("compartimento"));
				
				locais.add(local);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return locais;

	}
	
	public List<LocalVO> listByCompartimento(LocalVO vo)  {
		ResultSet rs = null;
		List<LocalVO> locais = new ArrayList<LocalVO>();
		try {
			rs = dao.listByCompartimento(vo);
			while(rs.next()){
				LocalVO local = new LocalVO();
				
				local.setId(rs.getInt("id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento(rs.getString("compartimento"));
				
				locais.add(local);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return locais;

	}
	

}
