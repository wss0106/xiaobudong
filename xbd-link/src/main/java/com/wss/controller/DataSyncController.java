package com.wss.controller;

import com.wss.service.DataSyncService;
import com.wss.xiaobudong.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sync/v1/")
public class DataSyncController {

    @Autowired
    private DataSyncService dataSyncService;

    @PostMapping("/add/{sid}")
    public JsonData syncData(@PathVariable Long sid) {
        dataSyncService.syncData(sid);
        String name = Thread.currentThread().getName();
        return JsonData.buildSuccess("数据同步已启动!"+name);
    }
}
