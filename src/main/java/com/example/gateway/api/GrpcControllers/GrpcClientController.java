package com.example.gateway.api.GrpcControllers;

import com.example.instructor.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcClientController extends ClientServiceGrpc.ClientServiceImplBase {

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8084).usePlaintext().build();
    private final ClientServiceGrpc.ClientServiceBlockingStub stub = ClientServiceGrpc.newBlockingStub(channel);

    @Override
    public void add(ClientRequest request, StreamObserver<ClientResponse> responseObserver) {
        ClientResponse response = stub.add(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void byId(ClientByIdRequest request, StreamObserver<ClientResponse> responseObserver) {
        ClientResponse response = stub.byId(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void all(AllClientsRequest request, StreamObserver<AllClientsResponse> responseObserver) {
        AllClientsResponse response = stub.all(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(ClientByIdRequest request, StreamObserver<DeleteClientResponse> responseObserver) {
        DeleteClientResponse response = stub.delete(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
