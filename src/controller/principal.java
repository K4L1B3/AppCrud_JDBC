
package controller;

import java.sql.Connection;

import dao.PessoaDao;
import dao.Imp.PessoaDaoImp;
import model.Pessoa;
import model.util.Conexao;

public class principal {

	public static void main(String[] args) {
		
		Conexao conexao = new Conexao();
		Connection conn = conexao.getConnection();
		
		// Salvar Pessoa
		
		Pessoa Luiz = new Pessoa();
		Luiz.setId(1);
		Luiz.setIdade(20);
		Luiz.setNome("Luiz");
		
		// Chamar o DAO para fazer a ação do metodo
		
		PessoaDao pessoaDao = new PessoaDaoImp();
		pessoaDao.Salvar(Luiz);
		
		
		
	}

}
