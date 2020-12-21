package com.example.gateway.api.GrpcControllers;

import com.example.worker.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcWorkerController extends WorkerServiceGrpc.WorkerServiceImplBase {

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7082).usePlaintext().build();
    private final WorkerServiceGrpc.WorkerServiceBlockingStub stub = WorkerServiceGrpc.newBlockingStub(channel);

    @Override
    public void add(WorkerRequest request, StreamObserver<WorkerResponse> responseObserver) {
        WorkerResponse response = stub.add(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void byId(WorkerByIdRequest request, StreamObserver<WorkerResponse> responseObserver) {
        WorkerResponse response = stub.byId(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void all(AllWorkersRequest request, StreamObserver<AllWorkersResponse> responseObserver) {
        AllWorkersResponse response = stub.all(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(WorkerByIdRequest request, StreamObserver<DeleteWorkerResponse> responseObserver) {
        DeleteWorkerResponse response = stub.delete(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
