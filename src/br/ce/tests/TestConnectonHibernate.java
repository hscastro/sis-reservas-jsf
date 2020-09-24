package br.ce.tests;

import br.ce.util.HibernateUtil;

public class TestConnectonHibernate {
	public static void main(String []args) {
		
		try{
			HibernateUtil.getSessionFactory();
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}

}
