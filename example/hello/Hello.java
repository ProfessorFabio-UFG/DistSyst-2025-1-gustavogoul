package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    
    // Novos métodos
    int add(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException;
    String echo(String msg) throws RemoteException;
}