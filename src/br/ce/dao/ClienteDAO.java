package br.ce.dao;

import java.util.List;

public interface ClienteDAO<C> {
	
	public boolean salvar(C c);
	public boolean editar(C c);
	public boolean excluir(C c);
	public C buscar(Long id);
	public List<C> listar();
}
