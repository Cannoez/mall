package com.zeal.mall.config;
//
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//
//import java.time.Duration;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description:对于缓存的配置类
 * @date: 2022-06-12 3:01
 */
//@Configuration
//@EnableCaching
//public class CacheConfig {
//    @Bean
//    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory){
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
//        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
//        cacheConfiguration = cacheConfiguration.entryTtl(Duration.ofSeconds(30));
//
//        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, cacheConfiguration);
//        return redisCacheManager;
//    }
//}
