/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 12/08/2021
 */

package DeploymentServerClient;

import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8080);

            Socket s = ss.accept();
            System.out.println("\nServer Started... ");
            System.out.println("Client Connected... ");
            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            int inputNumber = (int)input.readInt();
            Server server = new Server();

            System.out.println("Checking if is prime... ");
            String isPrime = server.isPrime(inputNumber);
            System.out.println(isPrime);
            output.writeUTF(isPrime);
            output.flush();
            output.close();
            ss.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
