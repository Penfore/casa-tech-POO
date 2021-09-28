package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.FuncionarioVO;
import src.model.vo.UsuarioVO;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao extends BaseDao{
	public void inserir(FuncionarioVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "Insert into Funcionario (nome,endereco,email,telefone,cargo,usuario_id) values (?,?,?,?,?,?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getEmail());
			ptst.setString(4,vo.getTelefone());
			ptst.setInt(5,vo.getCargo());
			ptst.setInt(6,vo.getUsuario().getId());

			ptst.execute();

		}catch( SQLException e) {
			System.out.println(e);
		}
	}
	
	public void removeById(FuncionarioVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "DELETE FROM Funcionario WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {

			ptst.setInt(1,vo.getId());
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}
	
	public void updateById(FuncionarioVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "UPDATE  Funcionario SET (nome,endereco,email,telefone,cargo,usuario_id) = (?,?,?,?,?,?) WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getEmail());
			ptst.setString(4,vo.getTelefone());
			ptst.setInt(5,vo.getCargo());
			ptst.setInt(6,vo.getUsuario().getId());
			ptst.setInt(7,vo.getId());
			
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}
	
	public List<FuncionarioVO> index() throws SQLException{
		conn = getConnection();
		String sql = "SELECT * FROM Funcionario INNER JOIN Usuario on Funcionario.usuario_id = Usuario.id";
		Statement st;
		ResultSet rs;
		List<FuncionarioVO> Funcionarios = new ArrayList<FuncionarioVO>();
		
		try {
			
			st = conn.createStatement(); 
			rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				
				FuncionarioVO funVO = new FuncionarioVO();
				UsuarioVO usuVO = new UsuarioVO();
				
				//OBJETO USUARIO
				usuVO.setId(rs.getInt("usuario_id"));
				usuVO.setNickName(rs.getString("nickName"));
				usuVO.setSenha(rs.getString("Senha"));
				
				funVO.setId(rs.getInt("id"));
				funVO.setNome(rs.getString("nome"));
				funVO.setEndereco(rs.getString("endereco"));
				funVO.setEmail(rs.getString("email"));
				funVO.setTelefone(rs.getString("telefone"));
				funVO.setCargo(rs.getInt("telefone"));	
				funVO.setUsuario(usuVO);

				
				Funcionarios.add(funVO);
				
				
			}
		}catch(SQLException e) {
			
		}
		return Funcionarios;
	}
}
