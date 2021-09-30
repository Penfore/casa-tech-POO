package src.model.dao;

import java.sql.SQLException;

public interface UsuarioInterDao<VO> {
	public boolean autenticar(VO entity) throws SQLException;
}
