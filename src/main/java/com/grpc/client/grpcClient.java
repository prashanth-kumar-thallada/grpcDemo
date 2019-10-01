package com.grpc.client;

import com.prashanth.grpcDemo.User.*;
import com.prashanth.grpcDemo.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class grpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        System.out.println("Inside Client, client listening to " + channel.authority());

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        request requestToServer = request.newBuilder().setName("Prashanth").build();
        response responseFromServer = userStub.sayHello(requestToServer);

        System.out.println(responseFromServer.getResponseMessage());

        channel.shutdown();

    }
}
