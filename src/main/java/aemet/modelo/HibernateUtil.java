package aemet.modelo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * Classe d'inicialitzacio del sessionFactory de Hibernate
 * @author david
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;
     
    static {
        Configuration conf = new Configuration();
        conf.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        sessionFactory = conf.buildSessionFactory(serviceRegistry);   
    }
     
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}