package ds.java.smartOffice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ds.java.smartOffice.DeskBookingGrpc.DeskBookingBlockingStub;
import ds.java.smartOffice.DeskBookingGrpc.DeskBookingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class GUIApplicationDeskBooking {
	
	private static DeskBookingBlockingStub blockingStub;
	private static DeskBookingStub asyncStub;

	private ServiceInfo deskBookingInfo;
	
	
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textMes;
	private JTextArea textResponse ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApplicationDeskBooking window = new GUIApplicationDeskBooking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUIApplicationDeskBooking() {
		
		String deskBooking_service_type = "_deskBooking._tcp.local.";
		discoverDeskBooking(deskBooking_service_type);
		
		String host = deskBookingInfo.getHostAddresses()[0];
		int port = deskBookingInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = DeskBookingGrpc.newBlockingStub(channel);

		asyncStub = DeskBookingGrpc.newStub(channel);

		
		initialize();
	}
	
	private void discoverDeskBooking(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Desk Booking Service resolved: " + event.getInfo());

					deskBookingInfo = event.getInfo();

					int port = deskBookingInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + deskBookingInfo.getNiceTextString());
					System.out.println("\t host: " + deskBookingInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Desk Booking Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Desk Booking Service added: " + event.getInfo());

					
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Smart Office Controller");
		frame.setBounds(100, 100, 350, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Enter desk number");
		textNumber1 = new JTextField();
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num1 = Integer.parseInt(textNumber1.getText());
				deskRequest req = deskRequest.newBuilder().setBookDesk(num1).build();
				
				deskReply response = blockingStub.bookDesk(req);
				
				textResponse.append(response.getDeskBooked()+ "\n");
				
				System.out.println("res: " + response.getDeskBooked());

			}
		});
			
		
		
		JLabel lblNewLabel_2 = new JLabel("Enter username");
		textMes = new JTextField();
		
		JButton btnLog = new JButton("Login");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mes = textMes.getText();
				//loginRequest req = loginRequest.newBuilder().setUsername(mes).build();
			
		
				StreamObserver<loginRequest> responseObserver = new StreamObserver<loginRequest>() {

					@Override
				public void onNext(loginRequest value) {
	            System.out.println("Final Response from server" + value.getUsername());

				
				}

				@Override
				public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
				}

				@Override
				public void onCompleted() {
				
				}};
			
				StreamObserver<loginRequest> requestObserver = asyncStub.portalLogin(responseObserver);
				requestObserver.onNext(loginRequest.newBuilder().setUsername(mes).build());
				textResponse.append("Username Logged in as" + mes + "\n");

				System.out.println("Client has sent it smessages");
				requestObserver.onCompleted();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		

			}
		
		});
		
		
		
		textResponse = new JTextArea(8, 20);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		panel_service_1.add(lblNewLabel_1);
		panel_service_1.add(textNumber1);
		panel_service_1.add(btnBook);
		textNumber1.setColumns(10);
		
		textMes.setColumns(10);
		panel_service_1.add(lblNewLabel_2);
		panel_service_1.add(textMes);
		panel_service_1.add(btnLog);
		panel_service_1.add(scrollPane);
	}

}



