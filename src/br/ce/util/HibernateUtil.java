package br.ce.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessao = builSessionFactory();

    private static SessionFactory builSessionFactory() {

        try{

            Configuration cfg = new Configuration();            
            cfg.configure("hibernate.cfg.xml");

            return cfg.buildSessionFactory();

        }catch(Throwable e) {
            System.out.println("Criação da SessionFactory falhou: "+e.getMessage());
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory() {
    	System.out.println("ok");
        return sessao;
    }
}