package model.util;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.SQLException;

	public class Conexao {

	        //Nome do usuário do mysql
	        private static final String USERNAME = "root";

	        //Senha do mysql
	        private static final String PASSWORD = "root";

	        //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
	        private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/banco";
	       
	     // Cria uma conexão com o banco de dados MySQL utilizando o nome de usuário e senha fornecidos
	     

	        
	        public Connection getConnection () {
	        	Connection conn = null;
	        	
	        	try {
	        		
	        		Class.forName("com.mysql.jdbc.Driver");
	        		
	        		conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	        		
	        		if (conn != null) {
	        			System.out.println("Banco Conectado");
	        		}
	        		
	        	}catch (Exception e) {
	        		System.out.println("Erro na conexão com o banco" + e.getMessage());
	        	}
	        	
	        	return conn;
	        	
	        }
	        
	        
	        public void fecharConexao(Connection conn) {
	        	
	        	try {
	        		conn.close();
	        		System.out.println("Conexão com o banco de dados encerrada com sucesso!");
	        	}catch (SQLException e) {
	        		System.out.println("Erro ao fechar conexão" + e.getMessage());
	        	}
	        }
	}
	        
	        
	     

