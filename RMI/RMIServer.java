package RMI;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Adder adder = new AdderImpl();
            Naming.rebind("rmi://localhost/AdderS", adder);
            System.out.println("RMI Server is Running !!!!!");

        } catch (Exception e) {
            System.out.println("Server Exception:" + e.toString());
            e.printStackTrace();}
        }
}