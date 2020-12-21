package com.example.gateway.api.GrpcControllers;

import com.example.instructor.*;
import com.example.instructor.InstructorServiceGrpc.InstructorServiceImplBase;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcInstructorController extends InstructorServiceImplBase {

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7080).usePlaintext().build();
    private final InstructorServiceGrpc.InstructorServiceBlockingStub stub = InstructorServiceGrpc.newBlockingStub(channel);

    @Override
    public void add(InstructorRequest request, StreamObserver<InstructorResponse> responseObserver) {
        InstructorResponse response = stub.add(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void byId(InstructorByIdRequest request, StreamObserver<InstructorResponse> responseObserver) {
        InstructorResponse response = stub.byId(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void all(AllInstructorsRequest request, StreamObserver<AllInstructorsResponse> responseObserver) {
        AllInstructorsResponse response = stub.all(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(InstructorByIdRequest request, StreamObserver<DeleteInstructorResponse> responseObserver) {
        DeleteInstructorResponse response = stub.delete(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
