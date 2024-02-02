/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T1
 * Date: 1.02,2024
 * Version: 1
 */

package lab1;

import java.io.*;
import java.net.*;

public class TCP_Server {
	public static void main(String[] args) {
		int serverPort = 12345;

		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);

			System.out.println("Wait connection...");

			Socket socket = serverSocket.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			String message = reader.readLine();

			String[] parts = message.split(" ", 2);
			int id = Integer.parseInt(parts[0]);

			String response = "#" + id + " received";

			writer.println(response);

			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
