package com.jkrzemien.automation.servicetesting.orm;

import com.jkrzemien.automation.servicetesting.github.models.MyPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

/**
 * Test using Hibernate ORM to map POJO to H2 (an in-memory, lightweight DB).
 * Settings for DB to connect to are in hibernate.properties file.
 *
 * @author Juan Krzemien
 */
public class OrmStandAlone {

    private static final SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(MyPojo.class)
            .buildSessionFactory();

    private static final ThreadLocal<Session> sessions = ThreadLocal.withInitial(sessionFactory::openSession);

    /**
     * Creates a MyPojo entry in DB
     *
     * @throws Exception
     */
    @Test
    public void ormTestSample() {
        try (Session session = sessions.get()) {
            Transaction tx = session.beginTransaction();
            session.save(new MyPojo("Ruso", new Date()));
            session.flush();
            tx.commit();
        }
        sessions.remove();
    }

}
