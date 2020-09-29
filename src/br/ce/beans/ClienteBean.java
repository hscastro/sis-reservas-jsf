package br.ce.beans;

//import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.ce.dao.ClienteDAO;
import br.ce.factory.ClienteDAOFactory;
import br.ce.impls.ClienteDAOImpl;
import br.ce.models.Cliente;

/**
 * sistema de reservas com jsf, maven, jpa e hibernate
 * Autor: Halyson Santos
 * Data: 27/09/2020
 **/

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean {
	
	private Cliente cliente;
	
	private ClienteDAO<Cliente> clienteDAO = new ClienteDAOImpl();
	
	private List<Cliente> listaClientes;

	public ClienteBean() {
		cliente = new Cliente();		
		listaClientes = clienteDAO.listar();		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String adicionar() {			
    	boolean add = false;
    	add = ClienteDAOFactory.criarCliente(cliente);
    	
    	if(add) {
    		listaClientes = ClienteDAOFactory.listarClientes();	
    		
    		FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage("Cliente cadastrado com sucesso!"));
    		
    		
    		return "add_sucesso";
    	}else {
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Erro no cadastrado!"));    		
    		return "add_erro";
    	}		
		
	}	

    public String novo(){
        return "add_new_equipamento"; 

//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("cad_equipamento.xhtml");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        
    }	

    public String editar() {
    	
    	boolean status = false;    	
    	status = clienteDAO.editar(cliente);
    	
    	if(status) {    		
    		listaClientes = clienteDAO.listar();
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Cliente atualizado com sucesso!"));
    		
    		return "editar_sucesso";
    	}else {    		
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Erro na Edição!"));
    		return "editar_erro";
    	}    	
    	
    }
    
    public String excluir() {    	
    	boolean status = false;    	
    	status = ClienteDAOFactory.excluirCliente(cliente);
    	
    	if(status) {    		
    		listaClientes = ClienteDAOFactory.listarClientes();	
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Cliente excluído com sucesso!"));
    		
    		return "delete_sucesso";
    	}else {    		
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Erro na Exclusão!"));
    		return "delete_erro";
    	}
    }     
    
}
