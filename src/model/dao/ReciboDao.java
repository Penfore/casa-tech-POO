package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.VendaVO;
import src.model.vo.ReciboVO;

import java.util.ArrayList;
import java.util.List;

public class ReciboDao extends BaseDao { 

    public void Inserir (ReciboVO vo) throws SQLException{
        conn = getConnection();
        String sql = "Insert into Recibo (vendaFinalizada) values (?)";
        PreparedStatement ptst = conn.prepareStatement(sql);
        try{            
        ptst.setVendaVO(1, vo.getVendaFinalizada());
        
        ptst.execute();
        }catch( SQLException e) {
			
        }

    }

    public void RemoveById (ReciboVO vo) throws SQLException{
        conn = getConnection();
        String sql = "Delete from Recibo where Id = ?";
        PreparedStatement ptst = conn.prepareStatement(sql);
        try{            
        ptst.setInt(1, vo.getId());
        ptst.execute();

        }catch( SQLException e ){

        }			
    }

    public void updateById(ReciboVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "UPDATE Recibo SET (vendaFinalizada) = (?) WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {
			
			ptst.setVendaVO(1, vo.getVendaFinalizada());
			ptst.setInt(3,vo.getId());
			
			ptst.execute();

			
		}catch( SQLException e) {
			
		}
	}

    public List<ReciboVO> index() throws SQLException{
		conn = getConnection();
		String sql = "SELECT * FROM Recibo";
		Statement st;
		ResultSet rs;
		List<ReciboVO> recibos = new ArrayList<ReciboVO>();
        try {
			
			st = conn.createStatement(); 
			rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				ReciboVO recVO = new ReciboVO();
				recVO.setVendaFinalizada(rs.getVendaCO("vendaFinalizada"));

				recibos.add(recVO);
				
			}
		}catch(SQLException e) {
			
		}
		return recibos;
    }
}