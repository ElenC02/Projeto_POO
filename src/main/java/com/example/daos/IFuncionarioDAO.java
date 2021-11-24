package com.example.daos;

import java.util.List;
import com.example.entity.Funcionario;

public interface IFuncionarioDAO {
	
	void adicionar(Funcionario f);
	  
	  List<Funcionario> pesquisarPorID(int id);
	  
	  void atualizar(int id, Funcionario p);
	  
	  void remover(int id);

}
