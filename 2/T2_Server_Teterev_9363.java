/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T2
 * Date: 1.02,2024
 * Version: 1
 */


package lab1;

import java.io.*;
import java.net.*;

public class UDP_Server {
	public static void main(String[] args) {
		int serverPort = 12345;
		String filePath = "pathToSave/file.mp3"; 

		try {
			DatagramSocket socket = new DatagramSocket(serverPort);

			FileOutputStream fileOutputStream = new FileOutputStream(filePath);

			byte[] buffer = new byte[1024];
			int packetsReceived = 0;

			while (true) {
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);

				if (packet.getLength() == 0) {
					break;
				}

				fileOutputStream.write(buffer, 0, packet.getLength());
				packetsReceived++;
			}

			fileOutputStream.close();

			System.out.println("Count packages: " + packetsReceived);

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
