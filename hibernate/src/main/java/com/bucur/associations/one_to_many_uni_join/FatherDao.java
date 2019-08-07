package com.bucur.associations.one_to_many_uni_join;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FatherDao {

    public void create(Father father) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(father);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Father findById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Father father = session.find(Father.class, id);
            return father;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
