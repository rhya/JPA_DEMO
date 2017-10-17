package test;

import entity.Mobile;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by admin on 2017/10/17.
 */
public class MainTest {

    @Test
    public void testFirstForJPA(){
        // SessionFactory;  => EntityManagerFactory
        // Session;         => EntityManager
        // Transaction;
        // OP;
        // Close();

        // 靡不有初，鲜克有终
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_DEMO");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        //新增
        transaction.begin();
        Mobile vivo = new Mobile("VIVO", 2000F);
        Mobile oppo = new Mobile("OPPO", 3322F);
        Mobile iphone = new Mobile("苹果", 6000F);
        Mobile huawei = new Mobile("华为", 5000F);
        em.persist(vivo);
        em.persist(oppo);
        em.persist(iphone);
        em.persist(huawei);

        transaction.commit();

        // 更新
        transaction.begin();
        iphone.setPrice(8888F);
        em.merge(iphone);
        transaction.commit();

        // 删除
        transaction.begin();
        em.remove(huawei);
        transaction.commit();

        // at last, 不要忘记释放资源
        em.close();
        emf.close();


    }
}
