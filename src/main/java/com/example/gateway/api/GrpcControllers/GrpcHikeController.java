package com.example.gateway.api.GrpcControllers;

import com.example.hike.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcHikeController extends HikeServiceGrpc.HikeServiceImplBase {

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7081).usePlaintext().build();
    private final HikeServiceGrpc.HikeServiceBlockingStub stub = HikeServiceGrpc.newBlockingStub(channel);

    @Override
    public void add(HikeRequest request, StreamObserver<HikeResponse> responseObserver) {
        HikeResponse response = stub.add(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void byId(HikeByIdRequest request, StreamObserver<HikeResponse> responseObserver) {
        HikeResponse response = stub.byId(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void all(AllHikesRequest request, StreamObserver<AllHikesResponse> responseObserver) {
        AllHikesResponse response = stub.all(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(HikeByIdRequest request, StreamObserver<DeleteHikeResponse> responseObserver) {
        DeleteHikeResponse response = stub.delete(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
