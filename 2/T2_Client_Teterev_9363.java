/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T2
 * Date: 1.02,2024
 * Version: 1
 */


package lab1;

import java.io.*;
import java.net.*;

public class UDP_Client {
	public static void main(String[] args) {
		String serverAddress = "localhost";
		int serverPort = 12345;

		try {
			DatagramSocket socket = new DatagramSocket();

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Input path: ");
			String filePath = reader.readLine();

			File file = new File(filePath);
			FileInputStream fileInputStream = new FileInputStream(file);

			byte[] buffer = new byte[1024];
			int bytesRead;
			int packetsSent = 0;

			while ((bytesRead = fileInputStream.read(buffer)) != -1) {
				DatagramPacket packet = new DatagramPacket(buffer, bytesRead, InetAddress.getByName(serverAddress),
						serverPort);
				socket.send(packet);
				packetsSent++;
			}

			fileInputStream.close();

			System.out.println("Count packages: " + packetsSent);

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
