package com.knoldus.controller;

import com.knoldus.model.CoreServiceGrpc;
import com.knoldus.model.PingResponse;
import com.knoldus.model.PingRequest;
import com.knoldus.service.PingService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@GRpcService
public class GrpcController extends CoreServiceGrpc.CoreServiceImplBase {
    @Autowired
    private PingService pingService;

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        responseObserver.onNext(pingService.ping(request));
        responseObserver.onCompleted();
    }
}
