package top.chuqin.jedis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisShardInfo;

/**
 * Created by wengchuqin on 2018/1/12.
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisConnectionFactory redisCF() {
        RedisConnectionFactory connectionFactory = new JedisConnectionFactory(new JedisShardInfo("192.168.215.130"));
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
        redis.setConnectionFactory(cf);
        redis.setKeySerializer(new StringRedisSerializer());
        return redis;
    }
}
