package test;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by admin on 2017/10/17.
 */
public class BaseTest {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    @Before
    public void first(){
        emf = Persistence.createEntityManagerFactory("JPA_DEMO2");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void last(){
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
