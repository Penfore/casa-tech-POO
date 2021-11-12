package src.model.bo;


import java.sql.SQLException;
import java.util.List;


public interface FuncionarioInterBO<VO> {
	public List<VO> findByEmail(VO entity) throws SQLException;
	public List<VO> listByCargo(VO entity) throws SQLException;
	public Integer quantidadeFuncionarios() throws SQLException;
}
