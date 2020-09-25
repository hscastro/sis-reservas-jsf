package br.ce.factory;

import java.util.List;

import br.ce.dao.EquipamentoDAO;
import br.ce.impls.EquipamentoDAOImpl;
import br.ce.models.Equipamento;


public class EquipamentoDAOFactory {
	
	private static EquipamentoDAO<Equipamento> equipamentoDAO = new EquipamentoDAOImpl();
	
		
	public static boolean criarEquipamento(Equipamento equipamento) {
		return equipamentoDAO.salvar(equipamento);
	}


	public static List<Equipamento> listarEquipamentos() {
		return equipamentoDAO.listar();
	}

}
