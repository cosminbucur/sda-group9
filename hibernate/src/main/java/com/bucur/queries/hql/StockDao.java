package com.bucur.queries.hql;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StockDao {

    private static final Logger logger = Logger.getLogger(StockDao.class.getName());

    private Session session;
    private Transaction tx;

    public void create(Stock stock) {
        try {
            startOperation();
            session.save(stock);
            tx.commit();
            // catching a HibernateException which extends PersistenceException
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error creating stock " + stock);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // TODO: implement find all (with hql query)
    public List findAllWithHqlQuery() {
//        String sql = "SELECT * FROM stock";
//        String hql = "FROM com.bucur.hql.Stock";
        String hql = "FROM Stock";

        List result = new ArrayList();
        try {
            startOperation();

            // query using HQL
            Query query = session.createQuery(hql, Stock.class);
            // use query from javax.persistence
            result = query.getResultList();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error finding stocks using: " + hql);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public List findAllByStockCodeWithNamedQuery(String stockCode) {
        List result = new ArrayList();
        try {
            startOperation();

            // named query with parameters using HQL
            Query query = session.createNamedQuery("findStockByStockCode", Stock.class);
            // use query from javax.persistence
            query.setParameter("stockCode", stockCode);
            result = query.getResultList();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error finding stocks using: " + "findStockByStockCode");
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

