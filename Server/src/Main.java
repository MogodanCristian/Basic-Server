import Models.Student;
import Services.ThreadService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static ServerSocket server;
    private static int port = 9876;
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

        server = new ServerSocket(port);
        server.setReuseAddress(true);

        while (true) {

            Socket client = server.accept();
            System.out.println("New client connected: "
                    + client.getInetAddress()
                    .getHostAddress());

            ThreadService clientThread = new ThreadService(client);
            new Thread(clientThread).start();
        }
    }
}