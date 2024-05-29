package com.wss.xiaobudong.utils;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

/**
 * 雪花算法id生成器
 **/

public class IDUtil {


    private static SnowflakeShardingKeyGenerator shardingKeyGenerator = new SnowflakeShardingKeyGenerator();

    /**
     * 雪花算法生成器
     * @return
     */
    public static   Comparable<?> geneSnowFlakeID(){

        return shardingKeyGenerator.generateKey();
    }

}
