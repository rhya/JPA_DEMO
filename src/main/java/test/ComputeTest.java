package test;


import entity.Computer;
import org.junit.Test;

/**
 * Created by admin on 2017/10/17.
 */
public class ComputeTest extends BaseTest{

    @Test
    public void testFirst(){
        Computer lenovo = new Computer("联想", 4444F);
        Computer dell = new Computer("戴尔", 3555F);

        em.persist(lenovo);
        em.persist(dell);
    }

    @Test
    public void testFirst2(){
        //  em.getReference()  等同于 hibernate中的 load() 方法
        //  em.find()          等同于 hibernate中的 get() 方法
        Computer lx = em.find(Computer.class, 6L);
        lx.setPrice(443f);
        em.merge(lx);
    }


}
