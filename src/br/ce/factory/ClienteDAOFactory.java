package br.ce.factory;

import java.util.List;

import br.ce.dao.ClienteDAO;
import br.ce.impls.ClienteDAOImpl;
import br.ce.models.Cliente;


public class ClienteDAOFactory {
	
	private static ClienteDAO<Cliente> clienteDAO = new ClienteDAOImpl();
	
		
	public static boolean criarCliente(Cliente cliente) {
		return clienteDAO.salvar(cliente);
	}

	public static boolean editarCliente(Cliente cliente) {
		return clienteDAO.editar(cliente);
	}
	
	public static List<Cliente> listarClientes() {
		return clienteDAO.listar();
	}
	
	public static boolean excluirCliente(Cliente cliente) {
		return clienteDAO.excluir(cliente);
	}
	
}
