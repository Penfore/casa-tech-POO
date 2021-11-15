package src.model.bo;


import java.sql.SQLException;
import java.util.List;

public interface VendaInterBO<VO> {
	public List<VO> findByCliente(VO entity) throws SQLException;
	public List<VO> findByDate(VO entity) throws SQLException;
	
	public Integer totalVendas() throws SQLException;
	public Integer vendasFinalizadas() throws SQLException;
	public Integer vendasCanceladas() throws SQLException;
	public Integer vendasDoMes() throws SQLException;
	public Float TotalPrecoVendido() throws SQLException;
	public String PagamentoMaisUsado() throws SQLException;
}
