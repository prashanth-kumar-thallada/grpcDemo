import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.userService;

import java.io.IOException;

public class GRPCserver {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090).addService(new userService()).build();

        server.start();
        System.out.println("Server started at " + server.getPort());

        server.awaitTermination();
        System.out.println("Exited at 0");
    }
}
