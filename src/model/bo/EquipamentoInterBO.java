package src.model.bo;


import java.sql.SQLException;
import java.util.List;

public interface EquipamentoInterBO<VO> {
	public List<VO> findByNome(VO entity) throws SQLException;
	public List<VO> findByCOD(VO entity) throws SQLException;
	public List<VO> listByResponsavel(VO entity) throws SQLException;
	public List<VO> listByLocal(VO entity) throws SQLException;
	
}
