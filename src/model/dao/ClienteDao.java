package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.ClienteVO;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends BaseDao { 

    public void Inserir (ClienteVO vo) throws SQLException{
        conn = getConnection();
        String sql = "Insert into Cliente (nome,rua,bairro,email,telefone,cep,cpf) values (?,?,?,?,?,?,?)";
        PreparedStatement ptst = conn.prepareStatement(sql);
        try{            
        ptst.setString(1, vo.getNome());
        ptst.setString(2, vo.getRua());
        ptst.setString(3, vo.getBairro());
        ptst.setString(4, vo.getEmail());
        ptst.setString(5, vo.getTelefone());
        ptst.setString(6, vo.getCep());
        ptst.setString(7, vo.getCpf());

        ptst.execute();
        }catch( SQLException e) {
			
        }

    }

    public void RemoveById (ClienteVO vo) throws SQLException{
        conn = getConnection();
        String sql = "Delete from Cliente where Id = ?";
        PreparedStatement ptst = conn.prepareStatement(sql);
        try{            
        ptst.setInt(1, vo.getId());
        ptst.execute();

        }catch( SQLException e ){

        }			
    }

    public void updateById(ClienteVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "UPDATE Cliente SET (nome,rua,bairro,email,telefone,cep,cpf) = (?,?,?,?,?,?,?) WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			
			ptst.setString(1, vo.getNome());
            ptst.setString(2, vo.getRua());
            ptst.setString(3, vo.getBairro());
            ptst.setString(4, vo.getEmail());
            ptst.setString(5, vo.getTelefone());
            ptst.setString(6, vo.getCep());
            ptst.setString(7, vo.getCpf());
            ptst.setInt(8, vo.getId());
			
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}

    public List<ClienteVO> index() throws SQLException{
		conn = getConnection();
		String sql = "SELECT * FROM Cliente";
		Statement st;
		ResultSet rs;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
        try {
			
			st = conn.createStatement(); 
			rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				ClienteVO cliVO = new ClienteVO();

				cliVO.setId(rs.getInt("id"));
				cliVO.setNome(rs.getString("nome"));
				cliVO.setRua(rs.getString("rua"));
				cliVO.setBairro(rs.getString("bairro"));
                cliVO.setEmail(rs.getString("email"));
                cliVO.setTelefone(rs.getString("telefone"));
                cliVO.setCep(rs.getString("cep"));
                cliVO.setCpf(rs.getString("cpf"));

				clientes.add(cliVO);
				
			}
		}catch(SQLException e) {
			
		}
		return clientes;
    }
}