package dao;

import java.util.List;

import model.Pessoa;

public interface PessoaDao {
	
	//Salvar, Alterar, Remover, Pesquisar, Listar todos
	
	
	public void Salvar (Pessoa pessoa);
	public void Alterar (Pessoa pessoa);
	public void Remover (int id);
	public Pessoa Pesquisar (int id);
	public List<Pessoa> ListarTodos();
	

}
