package br.ce.util;

import java.sql.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;


public class HibernateUtil {

    private static final SessionFactory fabricaDeSessoes = criarFabricaSessao();
    
    private static SessionFactory criarFabricaSessao() {

        try{

            Configuration cfg = new Configuration();            
            cfg.configure("hibernate.cfg.xml");

            return cfg.buildSessionFactory();

        }catch(Throwable e) {
            System.out.println("Criação da SessionFactory falhou: "+e.getMessage());
            throw new ExceptionInInitializerError();
        }
    }
    	
    //retorna uma conexão JDBC
    public static Connection getConexao() {
    	
    	Session session = fabricaDeSessoes.openSession();
    	Connection conexao  = null;
		
    	try{
			 conexao  = session.doReturningWork(new ReturningWork<Connection>() {
				
			  @Override
			  public Connection execute(Connection conn) {
			     return conn;
			  }    		    
		  });
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
    	
    	return conexao;
    }

    public static SessionFactory getFabricaSessoes() {
    	return fabricaDeSessoes;
    }
}