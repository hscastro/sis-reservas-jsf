package br.ce.beans;

import java.sql.Connection;
import java.util.HashMap;
//import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Faces;

import br.ce.dao.EquipamentoDAO;
import br.ce.factory.EquipamentoDAOFactory;
import br.ce.impls.EquipamentoDAOImpl;
import br.ce.models.Equipamento;
import br.ce.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

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
        return "add_new_equipamento"; 

//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("cad_equipamento.xhtml");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        
    }	

    public String editar() {
    	
    	boolean status = false;    	
    	status = equipamentoDAO.editar(equipamento);
    	
    	if(status) {    		
    		listaEquipamentos = equipamentoDAO.listar();
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Equipamento atualizado com sucesso!"));
    		
    		return "editar_sucesso";
    	}else {    		
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Erro na Edição!"));
    		return "editar_erro";
    	}    	
    	
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
    
    public String imprimirRelatorio() {
    	try { 
    		String caminhoRelatorio = Faces.getRealPath("/reports/rel_equipamentos.jasper");
    		//FacesContext context = FacesContext.getCurrentInstance();
    		//String caminhoRelatorio = context.getExternalContext().getRealPath("/reports/rel_equipamentos.jasper");
    		System.out.println("test 1 ");
    		Map<String, Object> parametros = new HashMap<>();
    		System.out.println("test 2");
    		//recebe uma conexão do hibernate e converter para uma conexão JDBC
    		Connection conn = HibernateUtil.getConexao();
    		System.out.println("test 3 "+caminhoRelatorio);
    		//prepara o relatório
     	    JasperPrint relatorio = JasperFillManager.fillReport(caminhoRelatorio, parametros, conn);
     	    System.out.println("test 4");
     	    //abbre o relatório para impressão
     	    JasperPrintManager.printReport(relatorio, true);
     	    System.out.println("test 5");
    	} catch (JRException e) {
    		FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Ocorreu um erro ao tentar gerar o relatório"));
    		//e.printStackTrace();
    	}
    	
    	return "test";
    }
    
}
