package br.edu.sp.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnetionFactory {
	
	//Nome do usuário mysql
	private static final String USERNAME = "root";
	
	//Senha do banco
	private static final String PASSWORD = "";
	
	//Caminho do DB
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	//Conexão com o Banco de dados
	public static Connection createConnectionToMysql() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		//Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		//Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMysql();
		
		//Testar se a conexão é nula
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
		
		
	}
	
}
