package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface VendaInterDao<VO> {
	public ResultSet findByCliente(VO entity) throws SQLException;
	public ResultSet findByDate(VO entity) throws SQLException;
}
