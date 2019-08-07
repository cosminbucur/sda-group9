package com.bucur.associations.one_to_many_bi;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChildDao {

    public void create(Child child) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(child);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Child findById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Child child = session.find(Child.class, id);
            return child;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
