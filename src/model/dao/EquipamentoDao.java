package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.EquipamentoVO;
import src.model.vo.LocalVO;
import src.model.vo.FuncionarioVO;
import src.model.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;
public class EquipamentoDao extends BaseDao{

	public void inserir(EquipamentoVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "Insert into Equipamento "
				+ "(nome,peso,codigo,quantidade,descricao,preco,responsavel_id,local_id) "
				+ "values (?,?,?,?,?,?,?,?)";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPeso());
			ptst.setString(3,vo.getCodigo());
			ptst.setInt(4,vo.getQuantidade());
			ptst.setString(5,vo.getDescricao());
			ptst.setDouble(6,vo.getPreco());
			ptst.setInt(7,vo.getResponsavel().getId());
			ptst.setInt(8,vo.getLocal().getId());
			
			ptst.execute();
		}catch( SQLException e) {
			
		}
	}
	
	public void removeById(EquipamentoVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "DELETE FROM Equipamento WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {

			ptst.setInt(1,vo.getId());
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}
	
	public void updateById(EquipamentoVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "UPDATE  Equipamento SET "
				+ "(nome,peso,codigo,quantidade,descricao,preco,responsavel_id,local_id) = "
				+ "(?,?,?,?,?,?,?,?) WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPeso());
			ptst.setString(3,vo.getCodigo());
			ptst.setInt(4,vo.getQuantidade());
			ptst.setString(5,vo.getDescricao());
			ptst.setDouble(6,vo.getPreco());
			ptst.setInt(7,vo.getResponsavel().getId());
			ptst.setInt(8,vo.getLocal().getId());
			ptst.setInt(9,vo.getId());
			
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}
	
	public List<EquipamentoVO> index() throws SQLException{
		conn = getConnection();
		String sql = "SELECT * FROM Equipamento "
				+ "INNER JOIN Local on Equipamento.local_id = Local.id"
				+ "INNER JOIN Funcionario on Equipamento.responsavel_id = Funcionario.id";
		Statement st;
		ResultSet rs;
		List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
		
		try {
			
			st = conn.createStatement(); 
			rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				//TALVEZ EU ESTEJA FAZENDO DO JEITO BURRO REVER ISSO AQ 
				EquipamentoVO equiVO = new EquipamentoVO();
				FuncionarioVO funVO = new FuncionarioVO();
				UsuarioVO usuVO = new UsuarioVO();
				LocalVO localVO = new LocalVO();
				
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
				
				localVO.setId(rs.getInt("id"));
				localVO.setCasa(rs.getString("casa"));
				localVO.setCompartimento(rs.getString("compartimento"));
				
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));	
				equiVO.setPreco(rs.getDouble("preco"));
				equiVO.setResponsavel(funVO);
				equiVO.setLocal(localVO);
				
				equipamentos.add(equiVO);
				
			}
		}catch(SQLException e) {
			
		}
		return equipamentos;
	}
}
