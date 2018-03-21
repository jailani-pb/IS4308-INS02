package week11.chatapplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9101);
			System.out.println("Connected to the server.");
			
			DataInputStream fromServer =
					new DataInputStream(socket.getInputStream());
			DataOutputStream toServer =
					new DataOutputStream(socket.getOutputStream());
			
			Scanner scanner = new Scanner(System.in);
			
			new Thread(new Runnable() {

				@Override
				public void run() {
					while(true) {
						try {
							if(fromServer.available() > 0) {
								String receivedMsg = fromServer.readUTF();
								System.out.println(">>> " + receivedMsg);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}).start();
			
			while(true) {
				String sendMsg = scanner.nextLine();
				toServer.writeUTF(sendMsg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}



