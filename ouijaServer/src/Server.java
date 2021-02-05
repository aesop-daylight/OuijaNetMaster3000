import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {

            // TCP-IP
            ServerSocket serverSocket = new ServerSocket(5050);
            Socket ouijaSocket = serverSocket.accept();

            var ouijaInput = new BufferedReader(new InputStreamReader(ouijaSocket.getInputStream()));

                    System.out.println(ouijaInput.readLine());

            var ouijaOutput = new PrintWriter(ouijaSocket.getOutputStream());

                    ouijaOutput.println("Hur lång kan den här strängen vara måntro?");
                    ouijaOutput.flush();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
