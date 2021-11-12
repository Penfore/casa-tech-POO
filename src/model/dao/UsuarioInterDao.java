package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UsuarioInterDao<VO> {
	public ResultSet autenticar(VO entity) throws SQLException;
	public ResultSet findByNickName(VO entity) throws SQLException;

}
