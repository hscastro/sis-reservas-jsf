package br.ce.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.ce.factory.EquipamentoDAOFactory;
import br.ce.models.Equipamento;

/**
 * sistema de reservas com jsf, maven, jpa e hibernate
 * Autor: Halyson Santos
 * Data: 24/09/2020
 **/

@ManagedBean(name = "equipamentoBean")
@ViewScoped
public class EquipamentoBean {
	
	private Equipamento equipamento = new Equipamento();
	
	private List<Equipamento> listaEquipamentos = new ArrayList<Equipamento>();

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
    	status = EquipamentoDAOFactory.criarEquipamento(equipamento);
    	
    	if(status) {    		
    		listaEquipamentos = EquipamentoDAOFactory.listarEquipamentos();	
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Equipamento exclu�do com sucesso!"));
    		return "delete_sucesso";
    	}else {    		
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Erro na Exclus�o!"));
    		return "delete_erro";
    	}
    }     
    
}
