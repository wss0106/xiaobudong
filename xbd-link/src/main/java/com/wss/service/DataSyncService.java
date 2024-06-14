package com.wss.service;

import com.wss.xiaobudong.utils.JsonData;

public interface DataSyncService {

    JsonData syncData(Long sourceDataId);
}
