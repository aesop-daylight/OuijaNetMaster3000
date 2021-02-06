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

            while (true) {
                Socket ouijaSocket = serverSocket.accept();

                Thread ouijaThread;
                ouijaThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread());
                        handleConnection(ouijaSocket);
                    }
                });

                ouijaThread.start();
            }
                } catch (IOException e) {
                    e.printStackTrace();
        }
    }

    private static void handleConnection(Socket ouijaSocket) {

        try {

            var ouijaInput = new BufferedReader(new InputStreamReader(ouijaSocket.getInputStream()));

                System.out.println(ouijaInput.readLine());
                PrintWriter ouijaOutput;

                ouijaOutput = new PrintWriter(ouijaSocket.getOutputStream());
                ouijaOutput.println("Hur lång kan den här strängen vara måntro?");
                ouijaOutput.flush();
                ouijaSocket.close();

                 } catch (IOException e) {
                        e.printStackTrace();
                    }



    }
}
