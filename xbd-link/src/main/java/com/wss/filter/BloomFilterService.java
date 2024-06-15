package com.wss.filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;

@Service
public class BloomFilterService {
    private RBloomFilter<String> bloomFilter;

    @Autowired
    private RedissonClient redissonClient;


    @PostConstruct
    public void init() {
        // 初始化布隆过滤器
        bloomFilter = redissonClient.getBloomFilter("bloomFilter");
        bloomFilter.tryInit(10000L, 0.01); // 预计插入10000个元素，误报率1%
    }

    public void add(String id) {
        bloomFilter.add(id);
    }

    public boolean mightContain(String id) {
        return bloomFilter.contains(id);
    }
}
