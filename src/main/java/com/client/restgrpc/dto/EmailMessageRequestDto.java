package com.client.restgrpc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class EmailMessageRequestDto {

    private String from;
    private boolean receipt;
    private long configurationId;
    private LocalDateTime sendBetweenStart;
    private LocalDateTime sendBetweenEnd;
    private String to;
    private String subject;
    private String bodyContentType;
    private String bodyContent;
    private String attachmentContent;
    private String attachmentContentType;
    private String gateway;

}
