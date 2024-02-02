/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T3
 * Date: 1.02,2024
 * Version: 1
 */

package lab2;

import java.io.*;
import java.net.*;

class Rectangle implements Serializable {

	private double a;

	private double b;

	public static final long serialVersionUID = 2L;

	public Rectangle(double a, double b) {

		this.a = a;

		this.b = b;

	}

	public double square() {

		return a * b;

	}

}

public class Client {

	public static void main(String[] args) {
		try {
			Rectangle rectangle = new Rectangle(5, 10);
			Socket socket = new Socket("localhost", 1234);
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			outputStream.writeObject(rectangle);
			double area = inputStream.readDouble();

			System.out.println("Ahea of the figure: " + area);

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

