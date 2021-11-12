package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface VendaInterDao<VO> {
	public ResultSet findByCliente(VO entity) throws SQLException;
	public ResultSet findByDate(VO entity) throws SQLException;
	public ResultSet totalVendas() throws SQLException;
	public ResultSet vendasFinalizadas() throws SQLException;
	public ResultSet vendasCanceladas() throws SQLException;
	public ResultSet vendasDoMes() throws SQLException;
	public ResultSet TotalPrecoVendido() throws SQLException;
	public ResultSet PagamentoMaisUsado() throws SQLException;
}
