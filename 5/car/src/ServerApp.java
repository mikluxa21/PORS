/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T3
 * Date: 1.02,2024
 * Version: 1
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerApp {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            CarService carService = new CarServiceImpl();
            registry.rebind("CarService", carService);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}


