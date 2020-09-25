package br.ce.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.ce.dao.EquipamentoDAO;
import br.ce.factory.EquipamentoDAOFactory;
import br.ce.impls.EquipamentoDAOImpl;
import br.ce.models.Equipamento;

/**
 * sistema de reservas com jsf, maven, jpa e hibernate
 * Autor: Halyson Santos
 * Data: 24/09/2020
 **/

@ManagedBean(name = "equipamentoBean")
@ViewScoped
public class EquipamentoBean {
	
	private Equipamento equipamento;
	
	private EquipamentoDAO<Equipamento> equipamentoDAO = new EquipamentoDAOImpl();
	
	private List<Equipamento> listaEquipamentos;

	public EquipamentoBean() {
		equipamento = new Equipamento();		
		listaEquipamentos = equipamentoDAO.listar();		
	}
	
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<Equipamento> getListaEquipamentos() {
		return listaEquipamentos;
	}

	public void setListaEquipamentos(List<Equipamento> listaEquipamentos) {
		this.listaEquipamentos = listaEquipamentos;
	}	
	
	public String adicionar() {			
    	boolean add = false;
    	add = EquipamentoDAOFactory.criarEquipamento(equipamento);
    	
    	if(add) {
    		listaEquipamentos = EquipamentoDAOFactory.listarEquipamentos();	
    		
    		FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage("Equipamento cadastrado com sucesso!"));
    		
    		
    		return "add_sucesso";
    	}else {
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Erro no cadastrado!"));    		
    		return "add_erro";
    	}		
		
	}	

    public String novo(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cad_equipamento.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return "cad_equipamento.xhtml"; 
    }	

    public String editar() {
    	return "editar_sucesso";
    }
    
    public String excluir() {    	
    	boolean status = false;    	
    	status = EquipamentoDAOFactory.excluirEquipamento(equipamento);
    	
    	if(status) {    		
    		listaEquipamentos = EquipamentoDAOFactory.listarEquipamentos();	
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Equipamento excluído com sucesso!"));
    		return "delete_sucesso";
    	}else {    		
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Erro na Exclusão!"));
    		return "delete_erro";
    	}
    }     
    
}
