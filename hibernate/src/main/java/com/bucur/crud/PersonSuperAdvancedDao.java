package com.bucur.crud;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.logging.Logger;

public class PersonSuperAdvancedDao {

    private static final Logger logger = Logger.getLogger(PersonSuperAdvancedDao.class.getName());

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
            session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error creating person " + person);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Finds a Person in the database.
     *
     * @param id person id
     * @return the found perrson instance or null if the entity does not exist
     */
    public Person findById(Long id) {
        // there is no need to commit a transaction since the query doesn't modify the state of the database
        Session session = HibernateUtil.getSessionFactory().openSession();
        Person person = session.find(Person.class, id);
        session.close();
        return person;
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
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error updating person " + person);
        } finally {
            if (session != null) {
                session.close();
            }
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
