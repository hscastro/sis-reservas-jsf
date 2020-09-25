package br.ce.impls;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.ce.dao.EquipamentoDAO;
import br.ce.models.Equipamento;
import br.ce.util.HibernateUtil;

public class EquipamentoDAOImpl implements EquipamentoDAO<Equipamento> {
	
	
	private Session session = null; 

	
	public EquipamentoDAOImpl() {
		this.session = HibernateUtil.getSessionFactory().openSession();	
	}

	@Override
	public boolean salvar(Equipamento e) {		
		try {
			this.session.beginTransaction();
			this.session.save(e);
			this.session.getTransaction().commit();
			
			return true;
			
		} catch (Exception e1) {
				e1.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean editar(Equipamento e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Equipamento buscar(Long id) {
		try {
			this.session.beginTransaction();
			Equipamento eq = this.session.get(Equipamento.class, id);
			this.session.getTransaction().commit();
			
			return eq;
			
		} catch (Exception e1) {
				e1.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Equipamento> listar() {
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Equipamento.class);
		criteria.setMaxResults(50);
		@SuppressWarnings("unchecked")
		List<Equipamento> lista = criteria.list();
		return lista;
	}

	@Override
	public boolean excluir(Equipamento e) {
		try {
			this.session.beginTransaction();
			this.session.delete(e);
			this.session.getTransaction().commit();
			
			return true;
			
		} catch(Exception e1){
				e1.printStackTrace();
		}
		
		return false;
	}
	
	

}
