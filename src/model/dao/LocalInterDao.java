package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface LocalInterDao<VO> {
	public ResultSet findByCasa(VO entity) throws SQLException;
	public ResultSet listByCompartimento(VO entity) throws SQLException;
}
