package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;
public class UsuarioDao extends BaseDao{
	
	public void inserir(UsuarioVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "Insert into Usuario (nickName,senha) values (?,?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1,vo.getNickName());
			ptst.setString(2,vo.getSenha());
			ptst.execute();
		}catch( SQLException e) {
			
		}
	}
	
	public void removeById(UsuarioVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "DELETE FROM Usuario WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {

			ptst.setInt(1,vo.getId());
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}
	
	public void updateById(UsuarioVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "UPDATE  Usuario SET (nickName,senha) = (?,?) WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			
			ptst.setString(1,vo.getNickName());
			ptst.setString(2,vo.getSenha());
			ptst.setInt(3,vo.getId());
			
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}
	
	public List<UsuarioVO> index() throws SQLException{
		conn = getConnection();
		String sql = "SELECT * FROM Usuario";
		Statement st;
		ResultSet rs;
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		
		try {
			
			st = conn.createStatement(); 
			rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				UsuarioVO usuVO = new UsuarioVO();
				usuVO.setId(rs.getInt("id"));
				usuVO.setNickName(rs.getString("nickName"));
				usuVO.setSenha(rs.getString("senha"));
				usuarios.add(usuVO);
				
			}
		}catch(SQLException e) {
			
		}
		return usuarios;
	}
	
}
