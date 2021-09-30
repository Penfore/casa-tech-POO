package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDao<VO> {
	public void store(VO entity) throws SQLException;
	public void updateById(VO entity) throws SQLException;
	public void removeById(VO entity) throws SQLException;
	public ResultSet index() throws SQLException;
	public ResultSet show(VO entity) throws SQLException;
}
