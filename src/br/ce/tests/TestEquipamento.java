package br.ce.tests;

import java.util.List;
import br.ce.impls.EquipamentoDAOImpl;
import br.ce.models.Equipamento;

public class TestEquipamento {

	public static void main(String[] args) {
		//Equipamento eq = new Equipamento();
		///eq.setCodigo(4L);
		//eq.setDescricao("chave de estrela");
		//eq.setQuantidade(new BigDecimal(22));
		//eq.setValor(new BigDecimal(9.29));
		EquipamentoDAOImpl imp = new EquipamentoDAOImpl();
		///EquipamentoDAOFactory.criarEquipamento(eq);
		//imp.salvar(eq);
		List<Equipamento> lista = imp.listar();
		for (Equipamento equipamento : lista) {
			System.out.println(equipamento.getDescricao());
		}	

	}

}
