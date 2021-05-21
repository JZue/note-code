package com.note.redis.demo.redisson.distributed.object;

import com.note.redis.demo.redisson.RedissonConfig;
import org.redisson.api.RBucket;
import org.redisson.api.RFuture;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

public class ObjectHolderDemo {
    public static void main(String[] args) {

    }


    /**
     *  同步方式的demo
     *
     *  同步的方式也是通过异步执行的future 实现的
     */
    public static void demoForSync() {
        RedissonClient redissonClient = RedissonConfig.getRedissonClient();
        RBucket<String> bucket = redissonClient.getBucket("anyObject");
        bucket.set("1");
        String s = bucket.get();
        bucket.trySet("2");
        bucket.compareAndSet("2","3");
        bucket.setIfExists("4",10, TimeUnit.MICROSECONDS);
    }

    /**
     *  异步方式的demo
     */
    public static void demoForAsync() {
        RedissonClient redissonClient = RedissonConfig.getRedissonClient();
        RBucket<String> bucket = redissonClient.getBucket("anyObject");
        RFuture<Void> voidRFuture = bucket.setAsync("1");
        RFuture<String> s = bucket.getAsync();
        RFuture<Boolean> r = bucket.trySetAsync("2");
        RFuture<Boolean> rs = bucket.compareAndSetAsync("2", "3");
        bucket.setIfExists("4",10, TimeUnit.MICROSECONDS);
    }




}
