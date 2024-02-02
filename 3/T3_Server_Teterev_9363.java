/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T3
 * Date: 1.02,2024
 * Version: 1
 */

package lab2;

import java.io.*;
import java.net.*;


public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1234);

			System.out.println("Wait connection...");

			Socket socket = serverSocket.accept();

			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

			Rectangle rectangle = (Rectangle) inputStream.readObject();

			double area = rectangle.square();

			outputStream.writeDouble(area);
			outputStream.flush();

			socket.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
