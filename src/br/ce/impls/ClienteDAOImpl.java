package br.ce.impls;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.ce.dao.ClienteDAO;
import br.ce.models.Cliente;
import br.ce.util.HibernateUtil;

public class ClienteDAOImpl implements ClienteDAO<Cliente> {
	
	private Session session = null; 

	
	public ClienteDAOImpl() {
		this.session = HibernateUtil.getFabricaSessoes().openSession();	
	}

	@Override
	public boolean salvar(Cliente c) {		
		try {
			this.session.beginTransaction();
			this.session.save(c);
			this.session.getTransaction().commit();
			
			return true;
			
		} catch (Exception e1) {
				e1.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean editar(Cliente c) {		
		try {
			this.session.beginTransaction();
			this.session.saveOrUpdate(c);
			this.session.getTransaction().commit();
			
			return true;
			
		} catch (Exception e1) {
				e1.printStackTrace();
		}
		
		return false;		
	}

	@Override
	public Cliente buscar(Long id) {
		try {
			this.session.beginTransaction();
			Cliente eq = this.session.get(Cliente.class, id);
			this.session.getTransaction().commit();
			
			return eq;
			
		} catch (Exception e1) {
				e1.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Cliente> listar() {
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.setMaxResults(50);
		@SuppressWarnings("unchecked")
		List<Cliente> lista = criteria.list();
		return lista;
	}

	@Override
	public boolean excluir(Cliente c) {
		try {
			this.session.beginTransaction();
			this.session.delete(c);
			this.session.getTransaction().commit();
			
			return true;
			
		} catch(Exception e1){
				e1.printStackTrace();
		}
		
		return false;
	}
	
}
