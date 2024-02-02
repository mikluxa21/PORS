import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarService extends Remote {
    void changeOil(Car car) throws RemoteException;
    void rotateTires(Car car) throws RemoteException;
}
