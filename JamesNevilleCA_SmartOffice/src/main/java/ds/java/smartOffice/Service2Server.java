package ds.java.smartOffice;

import java.io.IOException;
import java.util.Properties;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import ds.java.smartOffice.DeskBookingGrpc.DeskBookingImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.java.smartOffice.RoomControllerGrpc.RoomControllerImplBase;
import io.grpc.stub.StreamObserver;

public class Service2Server extends DeskBookingImplBase{
	public static void main(String[] args) {
		
		Service2Server deskBookingserver = new Service2Server();
		
		Properties prop = deskBookingserver.getProperties();
		
		deskBookingserver.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("service_port") );// #.50052;
		
		try {

			Server server = ServerBuilder.forPort(port)
					.addService(deskBookingserver)
					.build()
					.start();

			System.out.println("Desk Booking Server started, listening on " + port);

			server.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/service2.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Desk Booking Service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}

	private  void registerService(Properties prop) {
	
	 try {
           // Create a JmDNS instance
           JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
           
           String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
           String service_name = prop.getProperty("service_name")  ;// "example";
          // int service_port = 1234;
           int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50052;

           
           String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
           
           // Register a service
           ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
           jmdns.registerService(serviceInfo);
           
           System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
           
           // Wait a bit
           Thread.sleep(1000);

           // Unregister all services
           //jmdns.unregisterAllServices();

       } catch (IOException e) {
           System.out.println(e.getMessage());
       } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
}
	
	public void bookDesk(deskRequest request, 
			StreamObserver<deskReply> responseObserver) {
		
		int value = 0; 
		value = request.getBookDesk();
		
		deskReply reply = deskReply.newBuilder().setDeskBooked("The desk you have booked is number: " + value).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();
	}

	public StreamObserver<loginRequest>portalLogin(StreamObserver<loginRequest> responseObserver) {
		System.out.println("On server, inside the streaming method");
		return new StreamObserver<loginRequest>() {

			@Override
			public void onNext(loginRequest value) {
				System.out.println("On server, message receieved from client" + value.getUsername());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				loginRequest.Builder responseBuilder = loginRequest.newBuilder();
				
				responseBuilder.setUsername("Server says it has got your completed message");
				responseObserver.onNext(responseBuilder.build());

				responseObserver.onCompleted();
				
			}};
	}
}
