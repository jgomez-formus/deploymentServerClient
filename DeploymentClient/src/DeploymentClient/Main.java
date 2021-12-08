/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 12/08/2021
 */
package DeploymentClient;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            Socket s = new Socket("localhost",8080);
            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            System.out.print("\nEnter a Number : ");
            int inputNumber = scanner.nextInt();

            output.writeInt(inputNumber);
            String response = (String)input.readUTF();
            System.out.println("\nNumber Provided " + inputNumber + " Is Prime Number? : " + response);
            output.flush();
            output.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        scanner.close();
    }
}
