import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl extends UnicastRemoteObject implements CarService {
    private List<Car> carList;

    public CarServiceImpl() throws RemoteException {
        carList = new ArrayList<>();
    }

    @Override
    public void changeOil(Car car) throws RemoteException {
        System.out.println("Масло заменено");
    }

    @Override
    public void rotateTires(Car car) throws RemoteException {
        System.out.println("Колеса повёрнуты");
    }
}
