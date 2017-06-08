package ua.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.model.CatEntity;
import ua.until.HibernateUtil;

import java.util.List;

/**
 * Created by User on 07.06.2017.
 */
@Repository
public class DAO {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void addCat(CatEntity cat){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.persist(cat);
//        session.getTransaction().commit();
//        session.close();
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cat);
    }
    @SuppressWarnings("unchecked")
    public List<CatEntity> showCat(){
        Session session = this.sessionFactory.getCurrentSession();
        List<CatEntity> listCat = session.createQuery("from CatEntity").list();
        return listCat;
    }
    public void deleteCat(int id){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        CatEntity cat = (CatEntity) session.load(CatEntity.class, new Integer(id));
//        session.beginTransaction();
//        session.delete(cat);
//        session.getTransaction().commit();
//        session.close();
        Session session = this.sessionFactory.getCurrentSession();
        CatEntity cat = (CatEntity) session.load(CatEntity.class, new Integer(id));
        session.delete(cat);
    }
    public void editCat(CatEntity cat){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.update(cat);
//        session.getTransaction().commit();
//        session.close();
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cat);
    }
    public CatEntity searchCat(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CatEntity cat = (CatEntity) session.load(CatEntity.class, new Integer(id));
        return cat;
    }
}
