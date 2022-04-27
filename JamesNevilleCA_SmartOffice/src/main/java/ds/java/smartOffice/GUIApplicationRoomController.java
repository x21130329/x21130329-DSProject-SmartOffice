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

import ds.java.smartOffice.RoomControllerGrpc.RoomControllerBlockingStub;
import ds.java.smartOffice.RoomControllerGrpc.RoomControllerStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class GUIApplicationRoomController {
	
	private static RoomControllerBlockingStub blockingStub;
	private static RoomControllerStub asyncStub;

	private ServiceInfo roomControllerInfo;
	
	
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textMes;
	private JTextArea textResponse ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApplicationRoomController window = new GUIApplicationRoomController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUIApplicationRoomController() {
		
		String roomController_service_type = "_roomController._tcp.local.";
		discoverRoomController(roomController_service_type);
		
		String host = roomControllerInfo.getHostAddresses()[0];
		int port = roomControllerInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = RoomControllerGrpc.newBlockingStub(channel);

		asyncStub = RoomControllerGrpc.newStub(channel);

		
		initialize();
	}
	
	private void discoverRoomController(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Room Controller Service resolved: " + event.getInfo());

					roomControllerInfo = event.getInfo();

					int port = roomControllerInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + roomControllerInfo.getNiceTextString());
					System.out.println("\t host: " + roomControllerInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Room Controller Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Room Controller Service added: " + event.getInfo());

					
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
		
		JLabel lblNewLabel_1 = new JLabel("Enter Passcode");
		
		textNumber1 = new JTextField();
		
		
		JButton btnOpen = new JButton("Unlock");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(textNumber1.getText());
				doorRequest req = doorRequest.newBuilder().setPassCode(num1).build();
				
				doorReply response = blockingStub.doorAccess(req);
				
				textResponse.append(response.getSuccess()+ "\n");
				
				System.out.println("res: " + response.getSuccess());

			}
		});
		
		
		textResponse = new JTextArea(8, 20);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		panel_service_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Change Office Lighting" + "\n");
		
		
		
		textMes = new JTextField();
		
		JButton btnSwitch = new JButton("Switch");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mes = textMes.getText();
				lightRequest req = lightRequest.newBuilder().setLights(mes).build();
				
				lightReply response = blockingStub.lighting(req);
				
				textResponse.append(response.getLightState()+ "\n");
				
				System.out.println("res: " + response.getLightState());

			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Check Temperature in Office");
		JButton btnTemp = new JButton("Check");
		btnTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num2 = 0;
				tempRequest req = tempRequest.newBuilder().setTemp1(num2).build();
				
				String mes = "";
				tempRequest req2 = tempRequest.newBuilder().setTemp2(mes).build();
				
				Iterator<tempReply> response = blockingStub.airCon(req);
				Iterator<tempReply> response1 = blockingStub.airCon(req2);
				
				while(response.hasNext()) {
					tempReply temp = response.next();
					tempReply temp2 = response1.next();
					
					textResponse.append(((tempReplyOrBuilder) temp).getTempResult1()+ "");
					System.out.println(temp);
					textResponse.append(((tempReplyOrBuilder) temp2).getTempResult2()+ "\n");
					System.out.println(temp2);
				}
			}
		});
		
		
		
		
		panel_service_1.add(lblNewLabel_1);
		panel_service_1.add(textNumber1);
		panel_service_1.add(btnOpen);
		textNumber1.setColumns(10);
		panel_service_1.add(lblNewLabel_2);
		panel_service_1.add(btnSwitch);
		panel_service_1.add(lblNewLabel_3);
		panel_service_1.add(btnTemp);
		panel_service_1.add(scrollPane);
		
	}

}


