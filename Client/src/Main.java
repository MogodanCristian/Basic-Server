import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        try (Socket socket = new Socket("127.0.0.1", 9876)) {

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String line = null;
            do {
                line = sc.nextLine();
                out.println(line);
            }
            while (!"exit".equalsIgnoreCase(line));
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
