package com.knoldus.service;

import com.google.gson.Gson;
import com.knoldus.model.PingResponse;
import com.knoldus.model.PingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PingService {
    public PingResponse ping(PingRequest request) {
        log.info("Received hello message {}", new Gson().toJson(request));
        return PingResponse.newBuilder()
                .setMsg(request.getMsg())
                .setName("Harsh Vardhan")
                .build();
    }
}
