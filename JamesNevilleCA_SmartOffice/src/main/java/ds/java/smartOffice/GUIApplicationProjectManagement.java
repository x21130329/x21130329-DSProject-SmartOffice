package ds.java.smartOffice;
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

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ds.java.smartOffice.DeskBookingGrpc.DeskBookingBlockingStub;
import ds.java.smartOffice.DeskBookingGrpc.DeskBookingStub;
import ds.java.smartOffice.ProjectManagementGrpc.ProjectManagementBlockingStub;
import ds.java.smartOffice.ProjectManagementGrpc.ProjectManagementStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class GUIApplicationProjectManagement {
	private static ProjectManagementBlockingStub blockingStub;
	private static ProjectManagementStub asyncStub;

	private ServiceInfo projectManagementInfo;
	
	
	private JFrame frame;
	private JTextField textMes1;
	private JTextField textMes;
	private JTextArea textResponse ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApplicationProjectManagement window = new GUIApplicationProjectManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public GUIApplicationProjectManagement() {
		
		String projectManagement_service_type = "_projectManagement._tcp.local.";
		discoverProjectManagement(projectManagement_service_type);
		
		String host = projectManagementInfo.getHostAddresses()[0];
		int port = projectManagementInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = ProjectManagementGrpc.newBlockingStub(channel);

		asyncStub = ProjectManagementGrpc.newStub(channel);

		
		initialize();
	}

	private void discoverProjectManagement(String service_type) {
	
	
	try {
		// Create a JmDNS instance
		JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			
		jmdns.addServiceListener(service_type, new ServiceListener() {
			
			@Override
			public void serviceResolved(ServiceEvent event) {
				System.out.println("Project Management Service resolved: " + event.getInfo());

				projectManagementInfo = event.getInfo();

				int port = projectManagementInfo.getPort();
				
				System.out.println("resolving " + service_type + " with properties ...");
				System.out.println("\t port: " + port);
				System.out.println("\t type:"+ event.getType());
				System.out.println("\t name: " + event.getName());
				System.out.println("\t description/properties: " + projectManagementInfo.getNiceTextString());
				System.out.println("\t host: " + projectManagementInfo.getHostAddresses()[0]);
			
				
			}
			
			@Override
			public void serviceRemoved(ServiceEvent event) {
				System.out.println("Project Management Service removed: " + event.getInfo());

				
			}
			
			@Override
			public void serviceAdded(ServiceEvent event) {
				System.out.println("Project Management Service added: " + event.getInfo());

				
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
		
		JLabel lblNewLabel_1 = new JLabel("Enter Project");
		
		textMes = new JTextField();
		
		JButton btnDeadline = new JButton("Find");
		btnDeadline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mes = textMes.getText();
				deadlineRequest req = deadlineRequest.newBuilder().setProjectName(mes).build();
				deadlineReply response = blockingStub.deadline(req);
				
				textResponse.append(response.getProjectTime()+ "\n");
				
				System.out.println("res: " + response.getProjectTime());
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Enter Project");
		
		textMes1 = new JTextField();
		JButton btnState = new JButton("State");
		btnState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mes = textMes1.getText();
				stateRequest req = stateRequest.newBuilder().setProjectNameState(mes).build();
				stateReply response = blockingStub.checkState(req);
				
				textResponse.append(response.getProjectComplete()+ "\n");
				
				System.out.println("res: " + response.getProjectComplete());
			}
		});
		textResponse = new JTextArea(8, 20);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		panel_service_1.add(lblNewLabel_1);
		panel_service_1.add(textMes);
		textMes.setColumns(10);
		panel_service_1.add(btnDeadline);
		panel_service_1.add(lblNewLabel_2);
		panel_service_1.add(textMes1);
		textMes1.setColumns(10);
		panel_service_1.add(btnState);
		panel_service_1.add(scrollPane);
			
		
	}
}
