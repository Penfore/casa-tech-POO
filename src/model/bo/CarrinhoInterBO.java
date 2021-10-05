package src.model.bo;

import java.sql.SQLException;

public interface CarrinhoInterBO<VO> {
	public void listByVenda(VO vo) throws SQLException;
	public void listByProduto(VO vo) throws SQLException;
}
