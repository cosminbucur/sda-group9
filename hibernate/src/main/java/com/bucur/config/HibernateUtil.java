package com.bucur.config;

import com.bucur.associations.many_to_many.Post;
import com.bucur.associations.many_to_many.Tag;
import com.bucur.associations.one_to_many_bi.Child;
import com.bucur.associations.one_to_many_bi.Parent;
import com.bucur.associations.one_to_many_uni.Daughter;
import com.bucur.associations.one_to_many_uni.Mother;
import com.bucur.associations.one_to_many_uni_join.Father;
import com.bucur.associations.one_to_many_uni_join.Son;
import com.bucur.associations.one_to_one.Account;
import com.bucur.associations.one_to_one.Employee;
import com.bucur.crud.Person;
import com.bucur.hibernate_types.Player;
import com.bucur.queries.hql.Stock;
import com.bucur.queries.native_query.Trader;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        // load up the configuration using the hibernate.cfg.xml
        Configuration configuration = createConfig();

        // build the registry using the properties in the configuration
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // build the session factory from the service registry
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Configuration createConfig() {
        Configuration configuration = new Configuration();

        // hibernate settings equivalent to hibernate.cfg.xml's properties
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        configuration.setProperties(settings);

        // add annotated classes
        configuration.addAnnotatedClass(Person.class);

        // one to one
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Account.class);

        // one to many unidirectional
        configuration.addAnnotatedClass(Daughter.class);
        configuration.addAnnotatedClass(Mother.class);

        // one to many unidirectional join
        configuration.addAnnotatedClass(Father.class);
        configuration.addAnnotatedClass(Son.class);

        // one to many bidirectional
        configuration.addAnnotatedClass(Parent.class);
        configuration.addAnnotatedClass(Child.class);

        // many to many
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Tag.class);

        // hql
        configuration.addAnnotatedClass(Stock.class);
        configuration.addAnnotatedClass(Trader.class);

        // hibernate types
        configuration.addAnnotatedClass(Player.class);

        return configuration;
    }
}
