package com.example.gateway.api.GrpcControllers;

import com.example.order.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcOrderController extends OrderServiceGrpc.OrderServiceImplBase {

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7083).usePlaintext().build();
    private final OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

    @Override
    public void add(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        OrderResponse response = stub.add(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void byId(OrderByIdRequest request, StreamObserver<OrderResponse> responseObserver) {
        OrderResponse response = stub.byId(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void all(AllOrdersRequest request, StreamObserver<AllOrdersResponse> responseObserver) {
        AllOrdersResponse response = stub.all(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(OrderByIdRequest request, StreamObserver<DeleteOrderResponse> responseObserver) {
        DeleteOrderResponse response = stub.delete(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
