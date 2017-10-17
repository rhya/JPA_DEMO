package test;

import entity.Computer;
import entity.Mobile;
import org.junit.Test;

import java.util.List;

/**
 * Created by admin on 2017/10/17.
 */
public class QueryTest extends BaseTest {

    @Test public void testFind() {
        Mobile mobile = em.find(Mobile.class, 2L);
        System.out.println(mobile);
    }

    @Test public void testQuery() {
        String jpql = "from Computer where price > :pri";
        List<Computer> mobiles = em.createQuery(jpql, Computer.class)
                .setParameter("pri", 2000F)
                .getResultList();

        for (Computer mobile : mobiles) {
            System.out.println(mobile);
        }
    }
}
