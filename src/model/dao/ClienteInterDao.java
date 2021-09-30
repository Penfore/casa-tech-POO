package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ClienteInterDao<VO> {
	public ResultSet findByCPF(VO entity) throws SQLException;
	public ResultSet findByNome(VO entity) throws SQLException;
}
