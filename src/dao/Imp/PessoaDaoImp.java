package dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.PessoaDao;
import model.Pessoa;
import model.util.Conexao;

public class PessoaDaoImp implements PessoaDao {
	
	Conexao conexao = new Conexao();

	@Override
	public void Salvar(Pessoa pessoa) {
		Connection conn = conexao.getConnection();
		
		String sql = "INSERT INTO PESSOA(ID, NOME, IDADE)" + "VALUES(?, ?, ?)";
		
		try { 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pessoa.getId());
			ps.setString(2, pessoa.getNome());
			ps.setInt(3, pessoa.getIdade());
			ps.execute();
			System.out.println("Conta inserida com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir conta no banco:" + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	
	@Override
	public void Alterar(Pessoa pessoa) {
	
		Connection conn = conexao.getConnection();
		
		String sql = "UPDATE PESSOA SET ID = ?, NOME = ?, IDADE = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pessoa.getId());
			ps.setString(2, pessoa.getNome());
			ps.setInt(3, pessoa.getIdade());
			ps.executeUpdate();
			System.out.println("Conta atualizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar a conta");
		} finally {
			conexao.fecharConexao(conn);
		}
		
	}

	
	@Override
	public void Remover(int id) {
	
		Connection conn = conexao.getConnection();
		
		String sql = "DELETE FROM CONTA WHERE ID = ?";
		
		try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		System.out.println("Pessoa deletada com sucesso!");
		
		}catch (SQLException e) {
			System.out.println("Erro ao excluir essa pessoa" + e.getMessage());
			
		} finally {
			
			conexao.fecharConexao(conn);
		}	
	}
	
	
	@Override
	public Pessoa Pesquisar(int id) {
		
		Connection conn = conexao.getConnection();
		
		Pessoa pessoa = new Pessoa();
		
		String sql = "SELECT * FROM PESSOA WHERE ID = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			pessoa.setId(rs.getInt("ID"));
			pessoa.setNome(rs.getString("NOME"));
			pessoa.setIdade(rs.getInt("IDADE"));
		}
		
		} catch (SQLException e) {
			
			System.out.println("Erro ao pesquisar conta ou usuário inexistente" + e.getMessage());
			
		} finally {
			
			conexao.fecharConexao(conn);
			
		}
		
		return pessoa;
	}

	
	@Override
	public ArrayList<Pessoa> ListarTodos() {
		
		Connection conn = conexao.getConnection();
		
		ArrayList<Pessoa> retorno = new ArrayList<Pessoa>();
		
		String sql = "SELECT * FROM PESSOA";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("ID"));
				pessoa.setNome(rs.getNString("NOME"));
				pessoa.setIdade(rs.getInt("IDADE"));
				retorno.add(pessoa);
			}
			
		}catch (SQLException e) {
				System.out.println("Erro ao listar pessoas!" + e.getMessage());
			} finally {
				
				conexao.fecharConexao(conn);
				
			}
		return retorno;
	}	

}
