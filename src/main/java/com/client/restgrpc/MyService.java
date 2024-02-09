package com.client.restgrpc;

import com.client.restgrpc.dto.EmailMessageRequestDto;
import com.client.restgrpc.dto.EmailMessageResponseDto;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {

    @Timed("email.time")
    public EmailMessageResponseDto sendEmail(EmailMessageRequestDto emailMessageRequestDto){
        //TODO: This is the place where Feign Client will be used to send email
        return null;
    }
}
