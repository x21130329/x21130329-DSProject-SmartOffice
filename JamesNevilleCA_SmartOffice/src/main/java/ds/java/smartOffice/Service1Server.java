package ds.java.smartOffice;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

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

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Random;

public class Service1Server extends RoomControllerImplBase {
	
	public static void main(String[] args) {
		
		Service1Server roomControlserver = new Service1Server();
		
		Properties prop = roomControlserver.getProperties();
		
		roomControlserver.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("service_port") );// #.50051;
		
		try {

			Server server = ServerBuilder.forPort(port)
					.addService(roomControlserver)
					.build()
					.start();

			System.out.println("Room Controller Server started, listening on " + port);

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
		
		 try (InputStream input = new FileInputStream("src/main/resources/service1.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Room Controller Service properies ...");
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
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
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
	
	public void doorAccess(doorRequest request, 
			StreamObserver<doorReply> responseObserver) {
		
		String value = ""; 
		if (request.getPassCode() == 12345) {
			value = "Passcode Accepted. Welcome";
		}
		else {
			value = "Failed. Wrong Passcode Entered";
		}
		doorReply reply = doorReply.newBuilder().setSuccess(value).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();
	}
	
	public void lighting(lightRequest request, 
			StreamObserver<lightReply> responseObserver) {
		
		String value = ""; 
		if (request.getLights() == "") {
			value = "Lights state changed";
		}

		
		lightReply reply = lightReply.newBuilder().setLightState(value).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();
	}
	
	public void airCon(tempRequest request, 
			StreamObserver<tempReply> responseObserver) {
		
		int number = request.getTemp1();
		String firstString = request.getTemp2(); 
		
		int min = 10;
		int max = 30;

		Random random = new Random();
		number = random.nextInt(max + min) + min;
		
		if (number <=16) {
			firstString = "Too cold";
		}
		else if(number >16 && number  <=22){
			firstString = "Temp OK";
		}
		else {
			firstString = "Too Hot";
		}

		tempReply reply = tempReply.newBuilder().setTempResult1(number).build();
		tempReply reply2 = tempReply.newBuilder().setTempResult2(firstString).build();
		
		responseObserver.onNext(reply);
		responseObserver.onNext(reply2);

		responseObserver.onCompleted();
	}
}
