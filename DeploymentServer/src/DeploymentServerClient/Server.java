package DeploymentServerClient;

public class Server {

    public static String isPrime(int inputNumber) {
        if (inputNumber < 2) {
            return "No";
        }
        int i = 2;
        while (i < inputNumber) {
            if (inputNumber % i == 0) {
                return "No";
            }
            i++;
        }
        return "Yes";
    }
}
