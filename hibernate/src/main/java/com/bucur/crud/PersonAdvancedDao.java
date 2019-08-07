package com.bucur.crud;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.logging.Logger;

public class PersonAdvancedDao {

    private static final Logger logger = Logger.getLogger(PersonAdvancedDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Person into the database.
     *
     * @param person
     */
    public void create(Person person) {
        try {
            startOperation();
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error creating person " + person);
        }
    }

    public Person findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(Person.class, id);
    }

    /**
     * Updates the state of a detached Person.
     *
     * @param person
     */
    public void update(Person person) {
        try {
            startOperation();
            session.update(person);
            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error updating person " + person);
        }
    }

    /**
     * Delete a detached Person from the database.
     *
     * @param person
     */
    public void delete(Person person) {
        try {
            startOperation();
            session.delete(person);
            tx.commit();
            session.close();
        } catch (Exception e) {
            // hibernate exceptions are FATAL
            // need to rollback immediately
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error deleting person " + person);
        }
    }

    private void startOperation() {
        // obtain session
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();

        // obtain transaction
        tx = session.beginTransaction();
    }
}
