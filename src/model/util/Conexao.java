package model.util;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.SQLException;

	public class Conexao {

	        //Nome do usu�rio do mysql
	        private static final String USERNAME = "root";

	        //Senha do mysql
	        private static final String PASSWORD = "root";

	        //Dados de caminho, porta e nome da base de dados que ir� ser feita a conex�o
	        private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/banco";
	       
	     // Cria uma conex�o com o banco de dados MySQL utilizando o nome de usu�rio e senha fornecidos
	     

	        
	        public Connection getConnection () {
	        	Connection conn = null;
	        	
	        	try {
	        		
	        		Class.forName("com.mysql.jdbc.Driver");
	        		
	        		conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	        		
	        		if (conn != null) {
	        			System.out.println("Banco Conectado");
	        		}
	        		
	        	}catch (Exception e) {
	        		System.out.println("Erro na conex�o com o banco" + e.getMessage());
	        	}
	        	
	        	return conn;
	        	
	        }
	        
	        
	        public void fecharConexao(Connection conn) {
	        	
	        	try {
	        		conn.close();
	        		System.out.println("Conex�o com o banco de dados encerrada com sucesso!");
	        	}catch (SQLException e) {
	        		System.out.println("Erro ao fechar conex�o" + e.getMessage());
	        	}
	        }
	}
	        
	        
	     

