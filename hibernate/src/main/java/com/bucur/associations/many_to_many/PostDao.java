package com.bucur.associations.many_to_many;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostDao {

    private Session session;
    private Transaction tx;

    public void create(Post post) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(post);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Post findById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Post post = session.find(Post.class, id);
            return post;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
