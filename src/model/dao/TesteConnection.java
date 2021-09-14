package src.model.dao;

import src.model.vo.UsuarioVO;
import java.sql.SQLException;

import java.util.List;


public class TesteConnection {

	public static void main(String[] args) throws SQLException {
		BaseDao dao =  new BaseDao();
		System.out.println(dao.getConnection());
		
		
		//teste para inserir usuario
		UsuarioDao usuDao = new UsuarioDao();
		UsuarioVO usuVO = new UsuarioVO();
		usuVO.setNickName("Manteigx");
		usuVO.setSenha("123456789999");
		usuVO.setId(2);
		//usuDao.updateById(usuVO);
		
		List<UsuarioVO> usuarios = usuDao.index();
		
		for(UsuarioVO usuList: usuarios){
			System.out.println(usuList);
		}
	}

}