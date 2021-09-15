package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.LocalVO;

import java.util.ArrayList;
import java.util.List;

public class LocalDao extends BaseDao { 

    public void Inserir (LocalVO vo) throws SQLException{
        conn = getConnection();
        String sql = "Insert into Local (casa,compartimento) values (?,?)";
        PreparedStatement ptst = conn.prepareStatement(sql);
        try{            
        ptst.setString(1, vo.getCasa());
        ptst.setString(2, vo.getCompartimento());
        ptst.execute();
        }catch( SQLException e) {
			
        }

    }

    public void RemoveById (LocalVO vo) throws SQLException{
        conn = getConnection();
        String sql = "Delete from Local where Id = ?";
        PreparedStatement ptst = conn.prepareStatement(sql);
        try{            
        ptst.setInt(1, vo.getId());
        ptst.execute();

        }catch( SQLException e ){

        }			
    }

    public void updateById(LocalVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "UPDATE Local SET (casa,compartimento) = (?,?) WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			
			ptst.setString(1,vo.getCasa());
			ptst.setString(2,vo.getCompartimento());
			ptst.setInt(3,vo.getId());
			
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}

    public List<LocalVO> index() throws SQLException{
		conn = getConnection();
		String sql = "SELECT * FROM Local";
		Statement st;
		ResultSet rs;
		List<LocalVO> locais = new ArrayList<LocalVO>();
        try {
			
			st = conn.createStatement(); 
			rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				LocalVO locVO = new LocalVO();
				locVO.setId(rs.getInt("id"));
				locVO.setCasa(rs.getString("casa"));
				locVO.setCompartimento(rs.getString("compartimento"));
				locais.add(locVO);
				
			}
		}catch(SQLException e) {
			
		}
		return locais;
    }
}