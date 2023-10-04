package dev.garbacik.client;

import dev.garbacik.proto.HelloRequest;
import dev.garbacik.proto.HelloResponse;
import dev.garbacik.proto.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApplication {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
				.usePlaintext()
				.build();

		HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

		HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
				.setName("Pawel")
				.setId(10)
				.build());

		System.out.println(helloResponse.getGreeting());

		channel.shutdown();
	}

}
