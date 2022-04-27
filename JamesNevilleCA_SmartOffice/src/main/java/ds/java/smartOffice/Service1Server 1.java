package ds.java.smartOffice;

import java.io.IOException;
import java.util.logging.Logger;

import ds.java.smartOffice.RoomControllerGrpc.RoomControllerImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service1Server extends RoomControllerImplBase {
	private static final Logger logger = Logger.getLogger(Service1Server.class.getName());

	public static void main(String[] args) {
		
		Service1Server roomControlserver = new Service1Server();
		
		int port = 50051;
		
		try {
			Server server = ServerBuilder.forPort(port).addService(roomControlserver).build().start();
			 server.awaitTermination();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    logger.info("Server started, listening on " + port);
	    		    
	   
	}
	
	public void doorAccess(doorRequest request,  StreamObserver<doorReply> responseObserver) {
		    
		System.out.println("receiving door request");
		
		 doorReply reply = doorReply.newBuilder().setSuccess("Hello " + request.getPassCode()).build();
	     
		 responseObserver.onNext(reply);
	     
	     responseObserver.onCompleted();
	}
}
