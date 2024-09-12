package RMI;
import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Adder adder = (Adder) Naming.lookup("rmi://localhost/AdderS");
            int result = adder.add(20, 10);
            System.out.println("Result: "+ result);

        } catch (Exception e) {
            System.out.println("Client exception:" + e.toString());
            e.printStackTrace();}

    }
}
