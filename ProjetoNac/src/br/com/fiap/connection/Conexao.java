package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection connection;
	public static String url = "jdbc:mysql://localhost:3306/mydb";
	private static String usuario = "root";
	private static String senha = "";
	
	public static Connection getConnection(){
		
		if(connection == null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url,usuario,senha);
			}catch (ClassNotFoundException e) {
				System.out.println("Erro ao carregar Driver");
			}catch (SQLException e) {
				System.out.println("Erro ao estabelecer conexao com o banco de dados");
			}
		}
		
	return connection;}

}
