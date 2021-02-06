import java.io.*;
import java.net.Socket;


public class Client {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost" ,5050);

            var ouijaOutput = new PrintWriter(socket.getOutputStream());
                ouijaOutput.println("Server is listening!");
                ouijaOutput.flush();

            var ouijaInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(ouijaInput.readLine());

            var ouijaDataOutput = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
