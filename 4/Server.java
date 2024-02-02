/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T4
 * Date: 1.02,2024
 * Version: 1
 */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Calculator {
    public Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            Calculator calculator = new Server();

            Naming.rebind("//localhost/Calculator", calculator);

            System.out.println("Wait Connection...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }
}

