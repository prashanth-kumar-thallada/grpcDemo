package user;

import com.prashanth.grpcDemo.User.*;
import com.prashanth.grpcDemo.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;

public class userService extends userImplBase {
    @Override
    public void sayHello(request request, StreamObserver<response> responseObserver) {
        System.out.println("Inside server");

        String username = request.getName() + " \'added by server\'";

        response.Builder helloResponse = response.newBuilder();
        helloResponse.setResponseMessage(username);

        responseObserver.onNext(helloResponse.build());
        responseObserver.onCompleted();
    }
}
