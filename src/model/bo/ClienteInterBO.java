package src.model.bo;


import java.sql.SQLException;

public interface ClienteInterBO<VO> {
	public void findByCPF(VO entity) throws SQLException;
	public void findByNome(VO entity) throws SQLException;
}
