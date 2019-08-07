package com.bucur.crud;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.logging.Logger;

public class PersonDao {

    private static final Logger logger = Logger.getLogger(PersonDao.class.getName());

    public void create(Person person) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory() // get session factory
                    .openSession();     // get session
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe("error saving person " + person);
        }
    }

    public Person findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(Person.class, id);
    }

    public void update(Person person) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe("error updating person " + person);
        }
    }

    public void delete(Person person) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe("error updating person " + person);
        }
    }
}
