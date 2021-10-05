package src.model.bo;

import java.sql.SQLException;

public interface UsuarioInterBO<VO> {
	public void autenticar(VO entity) throws SQLException;
}
