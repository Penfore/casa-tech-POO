package src.model.bo;

import java.sql.SQLException;
import java.util.List;


public interface LocalInterBO<VO> {
	public List<VO> findByCasa(VO entity) throws SQLException;

	public List<VO> listByCompartimento(VO entity) throws SQLException;
	// public VO findLocal(VO entity) throws SQLException
}
