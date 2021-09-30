package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface FuncionarioInterDao<VO> {
	public ResultSet findByEmail(VO entity) throws SQLException;
	public ResultSet listByCargo(VO entity) throws SQLException;
}
