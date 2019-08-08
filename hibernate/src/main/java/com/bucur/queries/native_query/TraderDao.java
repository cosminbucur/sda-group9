package com.bucur.queries.native_query;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TraderDao {

    private static final Logger logger = Logger.getLogger(TraderDao.class.getName());

    private Session session;
    private Transaction tx;

    public void create(Trader trader) {
        try {
            startOperation();
            session.save(trader);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error creating trader " + trader);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List findAllWithNativeQuery() {
        String sql = "SELECT * FROM trader";

        List result = new ArrayList();
        try {
            startOperation();

            Query query = session.createNativeQuery(sql, Trader.class);
            result = query.list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error finding traders using: " + sql);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public List findAllByTraderNameWithNamedNativeQuery(String name) {
        List result = new ArrayList();
        try {
            startOperation();

            // named query with parameters using native SQL
            Query query = session.createNamedQuery("findTradersByNameNativeSQL", Trader.class);
            // use query from org.hibernate.query
            query.setParameter("name", name);
            result = query.list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error finding traders using: " + "findTradersByNameNativeSQL");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}

