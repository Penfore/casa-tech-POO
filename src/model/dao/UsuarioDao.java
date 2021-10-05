package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.UsuarioVO;

public class UsuarioDao<VO extends UsuarioVO> extends BaseDao<VO> implements UsuarioInterDao<VO>{

	public void store(VO vo) throws SQLException {
		String sql = "Insert into Usuario (nickName,senha) values (?,?)";
		PreparedStatement ptst = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		try {
			
			ptst.setString(1, vo.getNickName());
			ptst.setString(2, vo.getSenha());

			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException(" A inserção falhou :( ");
			}

			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if (generatedKeys.next()) {
				System.out.println(generatedKeys.getInt(1));
				vo.setUsuid(generatedKeys.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeById(VO vo) throws SQLException {
		String sql = "DELETE FROM Usuario WHERE id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {

			ptst.setInt(1, vo.getUsuid());
			ptst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateById(VO vo) throws SQLException {

		String sql = "UPDATE  Usuario SET (nickName,senha) = (?,?) WHERE id =?";
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		try {

			ptst.setString(1, vo.getNickName());
			ptst.setString(2, vo.getSenha());
			ptst.setInt(3, vo.getUsuid());

			ptst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet index() throws SQLException {
		String sql = "SELECT * FROM Usuario";
		Statement st;
		ResultSet rs = null;

		try {

			st = getConnection().createStatement();
			rs = st.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet show(VO vo) throws SQLException {
		String sql = "SELECT * FROM Usuario WHERE id =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getUsuid());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean autenticar(VO vo) throws SQLException {
		String sql = "SELECT * FROM Usuario WHERE nickName =? AND senha = ? ";
		PreparedStatement ptst;
		ResultSet rs = null;
		boolean login = false;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNickName());
			ptst.setString(1, vo.getSenha());

			rs = ptst.executeQuery();
			
			if (!rs.isBeforeFirst() ) {    
				throw new SQLException("login ou senha incorretos :( ");
			}else {
				login = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	public ResultSet findByNickName(VO vo) throws SQLException {
		String sql = "SELECT * FROM Usuario WHERE NickName =?";
		PreparedStatement ptst;
		ResultSet rs = null;

		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNickName());

			rs = ptst.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
