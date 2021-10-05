package src.model.bo;


import java.sql.SQLException;

public interface FuncionarioInterBO<VO> {
	public void findByEmail(VO entity) throws SQLException;
	public void listByCargo(VO entity) throws SQLException;
}
