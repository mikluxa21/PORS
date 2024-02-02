/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T1
 * Date: 1.02,2024
 * Version: 1
 */

package lab1;

import java.io.*;
import java.net.*;

public class TCP_Client {
	public static void main(String[] args) {
		String serverAddress = "localhost";
		int serverPort = 12345;

		try {
			Socket socket = new Socket(serverAddress, serverPort);

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			System.out.print("Input ID Message: ");
			int id = Integer.parseInt(reader.readLine());

			System.out.print("Input message text: ");
			String message = reader.readLine();

			writer.println(id + " " + message + "#");

			BufferedReader responseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = responseReader.readLine();

			System.out.println("Answer from srver: " + response);

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}