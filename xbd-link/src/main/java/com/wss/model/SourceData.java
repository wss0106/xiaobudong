package com.wss.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SourceData {
    private Long id;

    private String dataField;

    private LocalDateTime createdAt;

}
