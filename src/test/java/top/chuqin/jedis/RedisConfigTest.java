package top.chuqin.jedis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;

import static org.junit.Assert.*;

/**
 * Created by wengchuqin on 2018/1/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class RedisConfigTest {

    @Autowired
    private RedisTemplate<String, Product> redis;

    @Test
    public void testRedisTemplateNoNull() throws Exception {
        Assert.assertNotNull(redis);
    }

    @Test
    public void testSet() throws Exception {
        Product product = new Product();
        product.setName("ss");
        product.setPrice(222);
        product.setSku("sku" + Instant.now().getEpochSecond());
        redis.opsForValue().set(product.getSku(), product);
    }

    @Test
    public void testGet() throws Exception {
        Product product = redis.opsForValue().get("sku1515742388");
        System.out.println("produce:" + product);
    }

}