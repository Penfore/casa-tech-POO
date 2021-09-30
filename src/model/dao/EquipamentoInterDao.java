package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EquipamentoInterDao<VO> {
	public ResultSet findByNome(VO entity) throws SQLException;
	public ResultSet findByCOD(VO entity) throws SQLException;
	public ResultSet listByResponsavel(VO entity) throws SQLException;
	public ResultSet listByLocal(VO entity) throws SQLException;
}
