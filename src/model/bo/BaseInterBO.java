package src.model.bo;



import java.sql.SQLException;

import java.util.List;

public interface BaseInterBO<VO> {
	public void store(VO entity) throws SQLException;
	public void updateById(VO entity) throws SQLException;
	public void removeById(VO entity) throws SQLException;
	public List<VO> index() throws SQLException;
	public VO show(VO entity) throws SQLException;

}
