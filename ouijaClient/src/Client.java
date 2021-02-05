import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost" ,5050);

            var ouijaInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(ouijaInput.readLine());

            var ouijaOutput = new PrintWriter(socket.getOutputStream());
            ouijaOutput.println("Server is listening!");
            ouijaOutput.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
