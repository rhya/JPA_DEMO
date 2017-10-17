package test;

import entity.Game;
import org.junit.Test;

/**
 * Created by admin on 2017/10/17.
 */
public class GameTest extends BaseTest {

    @Test
    public void testFirst(){
        Game cj = new Game("吃鸡", 98f);
        Game lol = new Game("lol", 1f);

        em.persist(cj);
        em.persist(lol);
    }
}
