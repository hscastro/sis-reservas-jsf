package br.ce.dao;

import java.util.List;

public interface EquipamentoDAO<E> {
	
	public boolean salvar(E e);
	public boolean editar(E e);
	public boolean excluir(E e);
	public E buscar(Long id);
	public List<E> listar();
}
