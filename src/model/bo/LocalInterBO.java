package src.model.bo;

import java.sql.SQLException;

public interface LocalInterBO<VO> {
	public void findByCasa(VO entity) throws SQLException;
	public void listByCompartimento(VO entity) throws SQLException;
}
