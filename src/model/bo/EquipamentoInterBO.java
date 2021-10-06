package src.model.bo;


import java.sql.SQLException;

public interface EquipamentoInterBO<VO> {
	public void findByNome(VO entity) throws SQLException;
	public void findByCOD(VO entity) throws SQLException;
	public void listByResponsavel(VO entity) throws SQLException;
	public void listByLocal(VO entity) throws SQLException;
}
