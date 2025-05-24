package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            System.out.println("Registry has been located");
            Hello stub = (Hello) registry.lookup("Hello");
            System.out.println("Found server");

            String response = stub.sayHello();
            System.out.println("sayHello response: " + response);

            int sum = stub.add(5, 7);
            System.out.println("add(5, 7) = " + sum);

            int product = stub.multiply(3, 4);
            System.out.println("multiply(3, 4) = " + product);

            String echoed = stub.echo("Testing RMI");
            System.out.println("echo('Testing RMI') = " + echoed);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
