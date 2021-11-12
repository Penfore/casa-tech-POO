package src.model.bo;


import java.sql.SQLException;
import java.util.List;

public interface CarrinhoInterBO<VO> {
	public List<VO> listByVenda(VO vo) throws SQLException;
	public List<VO> listByProduto(VO vo) throws SQLException;
	public List<VO> listByProdutoVenda(VO vo) throws SQLException;
}
