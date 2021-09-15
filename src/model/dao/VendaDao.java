package src.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.vo.VendaVO;
import src.model.vo.ClienteVO;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class VendaDao extends BaseDao { 

    public void Inserir (VendaVO vo) throws SQLException{
        conn = getConnection();
        String sql = "Insert into Venda (precoTotal,codigo,dataDeCompra,status,comprador,carrinhoCompras) values (?,?,?,?,?,?)";
        PreparedStatement ptst = conn.prepareStatement(sql);
        try{            
        ptst.setFloat(1, vo.getPrecoTotal());
        ptst.setString(2, vo.getCodigo());
        ptst.setCalendar(3,vo.getDataDeCompra());
        ptst.setString(4, vo.getStatus());
        ptst.setClienteVO(5, vo.getcomprador());
        ptst.ArrayList(6, vo.getCarrinhoCompras());
        ptst.execute();
        }catch( SQLException e) {
			
        }

    }

    public void RemoveById (VendaVO vo) throws SQLException{
        conn = getConnection();
        String sql = "Delete from Venda where Id = ?";
        PreparedStatement ptst = conn.prepareStatement(sql);
        try{            
        ptst.setInt(1, vo.getId());
        ptst.execute();

        }catch( SQLException e ){

        }			
    }

    public void updateById(VendaVO vo) throws SQLException  {
		conn = getConnection();
		String sql = "UPDATE Venda SET (precoTotal,codigo,dataDeCompra,status,comprador,carrinhoCompras) = (?,?,?,?,?,?) WHERE id =?";
		PreparedStatement ptst = conn.prepareStatement(sql);
		try {			
			ptst.setFloat(1, vo.getPrecoTotal());
            ptst.setString(2, vo.getCodigo());
            ptst.setCalendar(3,vo.getDataDeCompra());
            ptst.setString(4, vo.getStatus());
            ptst.setClienteVO(5, vo.getcomprador());
            ptst.ArrayList(6, vo.getCarrinhoCompras());
			
            ptst.execute();			
		}catch( SQLException e) {
			
		}
	}

    public List<VendaVO> index() throws SQLException{
		conn = getConnection();
		String sql = "SELECT * FROM Venda";
		Statement st;
		ResultSet rs;
		List<VendaVO> vendas = new ArrayList<VendaVO>();
        try {
			
			st = conn.createStatement(); 
			rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				VendaVO vendaVO = new VendaVO();

                vendaVO.setPrecoTotal(rs.getFloat("precoTotal"));
				vendaVO.setCodigo(rs.getString("codigo"));
				vendaVO.setDataDeCompra(rs.getCalendar("dataDeCompra"));
				vendaVO.setStatus(rs.getString("Status"));
                vendaVO.setComprador(rs.getClienteVO("Comprador"));
                vendaVO.setCarrinhoCompras(rs.getArrayList("carrinhoDeCompras"));
				vendas.add(vendaVO);
				
			}
		}catch(SQLException e) {
			
		}
		return vendas;
    }
}