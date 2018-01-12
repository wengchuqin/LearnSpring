package top.chuqin.repository.impl.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.chuqin.domian.Spitter;
import top.chuqin.repository.SpitterRepository;

import static org.junit.Assert.*;

/**
 * Created by wengchuqin on 2018/1/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class JdbcSpitterRepositoryTest {

    @Autowired
    private SpitterRepository spitterRepository;

    @Test
    public void testNotNull(){
        Assert.assertNotNull(spitterRepository);
    }

    @Test
    public void testCount() throws Exception {
        System.out.println(spitterRepository.count());
    }

    @Test
    public void testSave() throws Exception {
        Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee",
                "newbee@habuma.com");
        spitterRepository.save(spitter);
    }

    @Test
    public void testFindOne() throws Exception {
        Spitter spitter = spitterRepository.findOne(1);
        System.out.println(spitter);
    }

    @Test
    public void testFindByUsername() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }
}