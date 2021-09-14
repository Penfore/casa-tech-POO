package src.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao{
    private static Connection conn = null;
		
	// DADOS CONEXÃO FULVIN :)    
	//    private static final String url = "jdbc:postgresql://localhost:5432/Casa-Tech-POO"; 
	//    private static final String usuario = "postgres"; 
	//    private static final String senha = "";
	 

    //DADOS DE CONEXÂO DA ISABELE :)
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String usuario = "postgres";
    private static final String senha = "123";

    public Connection getConnection()
    {
        if (conn == null)
        {
            try 
            {
                conn = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            return conn;
        } else 
        {
            return conn;
        }
    }


    public static void closeConnection()
    {
        if (conn != null)
        {
            try 
            {
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        conn = null;
    }

}