package src.model.bo;


import java.sql.SQLException;

public interface VendaInterBO<VO> {
	public void findByCliente(VO entity) throws SQLException;
	public void findByDate(VO entity) throws SQLException;
}
