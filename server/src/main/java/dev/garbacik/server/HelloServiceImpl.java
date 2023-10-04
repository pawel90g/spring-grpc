package dev.garbacik.server;

import dev.garbacik.proto.HelloRequest;
import dev.garbacik.proto.HelloResponse;
import dev.garbacik.proto.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {

  @Override
  public void hello(
      HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

    String greeting = new StringBuilder()
        .append("Hello, ")
        .append(request.getName())
        .append(" [ID: ")
        .append(request.getId())
        .append("]")
        .toString();

    HelloResponse response = HelloResponse.newBuilder()
        .setGreeting(greeting)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
