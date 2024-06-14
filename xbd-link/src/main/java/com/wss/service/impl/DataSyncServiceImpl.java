package com.wss.service.impl;

import com.wss.model.SourceData;
import com.wss.model.SyncLog;
import com.wss.service.DataSyncService;
import com.wss.xiaobudong.utils.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DataSyncServiceImpl implements DataSyncService {


    /**
     * 你在一个方法上使用 @Async("getAsyncExecutor")，Spring会使用你配置的名为 getAsyncExecutor 的线程池来执行这个方法。具体的工作原理如下：
     *
     * 	•	初始化阶段：在Spring容器启动时，AsyncConfig类中的 getAsyncExecutor 方法会被调用，创建并初始化一个 ThreadPoolTaskExecutor 实例。这个实例会被注册为Spring的一个Bean，并命名为 getAsyncExecutor。
     * 	•	方法调用阶段：当你调用一个带有 @Async("getAsyncExecutor") 注解的方法时，Spring会从容器中获取名为 getAsyncExecutor 的线程池，并将这个方法的执行任务提交给线程池。
     * 	•	线程池管理：ThreadPoolTaskExecutor 管理一个线程池，包括线程的创建、销毁以及任务的调度。线程池会重用已有的线程，而不是每次都创建新线程，从而提高效率。
     * @param sourceDataId
     * @return
     */
    @Async("getAsyncExecutor")
    public JsonData syncData(Long sourceDataId) {
        //获取平台数据,构建日志信息
        SourceData sourceData = new SourceData();
        sourceData.setId(123L);
        sourceData.setDataField("1234L");
        sourceData.setCreatedAt(LocalDateTime.now());
        SyncLog syncLog = new SyncLog();
        syncLog.setSourceData(sourceData);
        syncLog.setSyncTime(LocalDateTime.now());

        try {
            // 调用另一个平台的API同步数据
            boolean success = syncToAnotherPlatform(sourceData);
            if (success) {
                syncLog.setStatus("SUCCESS");
            } else {
                syncLog.setStatus("FAILURE");
                syncLog.setFailureReason("Unknown failure reason");
            }
        } catch (Exception e) {
            syncLog.setStatus("FAILURE");
            syncLog.setFailureReason(e.getMessage());
        }

//        syncLogRepository.save(syncLog);
        log.info("数据同步完成,日志记录成功");
        return JsonData.buildSuccess();
    }

    private boolean syncToAnotherPlatform(SourceData sourceData) {
        try {
            log.info("同步工作进行中:{}",Thread.currentThread().getName());
            Thread.sleep(10000L);
            // 实现同步到另一个平台的逻辑
            // 例如，调用远程API并返回同步结果
            log.info("同步工作完成{}",Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true; // 假设同步成功
    }
}