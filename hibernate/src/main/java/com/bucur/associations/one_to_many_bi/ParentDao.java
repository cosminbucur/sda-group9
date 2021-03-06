package com.bucur.associations.one_to_many_bi;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParentDao {

    public void create(Parent parent) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(parent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Parent findById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Parent parent = session.find(Parent.class, id);
            return parent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
