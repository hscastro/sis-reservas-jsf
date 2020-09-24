package br.ce.util;

import java.math.BigDecimal;

import br.ce.impls.EquipamentoDAOImpl;
import br.ce.models.Equipamento;

public class TestEquipamento {

	public static void main(String[] args) {
		Equipamento eq = new Equipamento();
		///eq.setId(1L);
		eq.setDescricao("chave de fenda");
		eq.setQuantidade(new BigDecimal(10));
		eq.setValor(new BigDecimal(16.99));
		EquipamentoDAOImpl imp = new EquipamentoDAOImpl();
		imp.salvar(eq);

	}

}
