package ua.until;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 07.06.2017.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }
}
