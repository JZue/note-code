package com.note.redis.demo.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonConfig {

    public static  RedissonClient getRedissonClient () {
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:7181");
        return Redisson.create(config);
    }

}
