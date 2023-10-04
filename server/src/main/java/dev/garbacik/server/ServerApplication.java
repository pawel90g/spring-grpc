package dev.garbacik.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ServerApplication {

  public static void main(String[] args) throws IOException, InterruptedException {

    Server server = ServerBuilder
        .forPort(8080)
        .addService(new HelloServiceImpl()).build();

    server.start();
    server.awaitTermination();
  }

}
