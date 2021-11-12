package src.model.bo;


import java.sql.SQLException;
import java.util.List;

public interface VendaInterBO<VO> {
	public List<VO> findByCliente(VO entity) throws SQLException;
	public List<VO> findByDate(VO entity) throws SQLException;
}
