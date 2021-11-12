package src.model.bo;

import java.sql.SQLException;

public interface UsuarioInterBO<VO> {
	public VO autenticar(VO entity) throws SQLException;
}
