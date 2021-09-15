package src.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    Connection conn = null;
		
	// DADOS CONEX�O FULVIN :)    
	//    private static final String url = "jdbc:postgresql://localhost:5432/Casa-Tech-POO"; 
	//    private static final String usuario = "postgres"; 
	//    private static final String senha = "";
	 

    //DADOS DE CONEX�O DA ISABELE :)
    //  private static final String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=casatech";
    //  private static final String usuario = "postgres";
    //  private static final String senha = "123";


    //DADOS DE CONEX�O DO DAVI :D
    private static final String url = "jdbc:postgresql://localhost:5432/CasaTech-POO";
    private static final String usuario = "postgres";
    private static final String senha = "1234";

    public Connection getConnection() throws SQLException{
        if (conn == null){
            try {
                conn = DriverManager.getConnection(url, usuario, senha);
            }catch (SQLException e){
                e.printStackTrace();
            }
            return conn;
            
        }else{
            return conn;
        }
    }


   

}