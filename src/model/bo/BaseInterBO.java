package src.model.bo;


import java.sql.SQLException;

public interface BaseInterBO<VO> {
	public void store(VO entity) throws SQLException;
	public void updateById(VO entity) throws SQLException;
	public void removeById(VO entity) throws SQLException;
	public void index() throws SQLException;
	public void show(VO entity) throws SQLException;

}
