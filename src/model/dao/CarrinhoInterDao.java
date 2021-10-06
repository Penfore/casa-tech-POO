package src.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CarrinhoInterDao<VO> {
	public ResultSet listByVenda(VO vo) throws SQLException;
	public ResultSet listByProduto(VO vo) throws SQLException;
	public ResultSet listByProdutoVenda(VO vo) throws SQLException;
}
