package com.wss.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class SyncLog {
    @Id
    private Long id;


    private SourceData sourceData;


    private String status;


    private String failureReason;


    private LocalDateTime syncTime;

    // getters and setters
}
