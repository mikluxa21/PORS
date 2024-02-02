/*
 * Created: Teterev Nikolai Valerevich 9363
 * Task: T5
 * Date: 5.02,2024
 * Version: 1
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientApp {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            CarService carService = (CarService) registry.lookup("CarService");

            Car car1 = new Car("Toyota", "Camry", 2020);
            Car car2 = new Car("Honda", "Civic", 2019);

            carService.changeOil(car1);
            carService.rotateTires(car2);

            System.out.println("Services called successfully.");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

