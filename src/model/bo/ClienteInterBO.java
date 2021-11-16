package src.model.bo;


import java.sql.SQLException;
import java.util.List;

public interface ClienteInterBO<VO> {
	public List<VO> findByCPF(VO entity) throws SQLException;
	public List<VO> findByNome(VO entity) throws SQLException;
	public Integer quantidadeClientes() throws SQLException;
	
}
