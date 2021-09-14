package src.model.dao;

public class TesteConnection {

	public static void main(String[] args) {
		BaseDao dao =  new BaseDao();
		
		System.out.println(dao.getConnection());

	}

}