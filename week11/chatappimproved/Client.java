package week11.chatappimproved;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	static boolean chatActive = true;
	
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Type your name: ");
			String name = scanner.nextLine();
			
			Socket socket = new Socket("192.168.0.107", 9101);
			System.out.println("Connected to server.");
			
			DataInputStream fromServer =
					new DataInputStream(socket.getInputStream());
			DataOutputStream toServer =
					new DataOutputStream(socket.getOutputStream());
			
			toServer.writeUTF(name);
			String otherClientName = fromServer.readUTF();
			String otherClientIP = fromServer.readUTF();
			
			System.out.println("Connected with " + otherClientName 
					+ " (" + otherClientIP + ").");
			
			new Thread(new Runnable() {

				@Override
				public void run() {
					while(chatActive) {
						try {
							if(fromServer.available() > 0) {
								String receivedMsg = fromServer.readUTF();
								System.out.println(">>> " + receivedMsg);
								chatActive = fromServer.readBoolean();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}).start();
			
			while(chatActive) {
				String sendMsg = scanner.nextLine();
				toServer.writeUTF(sendMsg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}











