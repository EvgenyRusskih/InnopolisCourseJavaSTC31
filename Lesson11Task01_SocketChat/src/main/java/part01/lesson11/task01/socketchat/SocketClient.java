package part01.lesson11.task01.socketchat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket client class
 * Client for connect to Socket Server
 * Edit run config and check allow parallel run (run parallel clients)
 */
public class SocketClient {
    /**
     * Logger log4g
     * Server host (network name or ip addres server )
     * Socket port number for client listening (should be free)
     */
    private static final Logger logger = LogManager.getLogger(SocketClient.class);
    private static final String host = "localhost";
    private static final int port = 51111;

    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient();
        socketClient.startClient();
    }

    /**
     * Start client
     * Message read console and send to adress server host:port
     */
    private void startClient() {
        try {
            Socket socket = new Socket(host, port);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                 Scanner console = new Scanner(System.in)
            ) {
                logger.info("Enter you name and send message: ");
                // Читаем входящие сообщения (в новом потоке)
                new Thread(() -> {
                    while (true) {
                        try {
                            logger.info("Input message: " + reader.readLine());
                        } catch (IOException e) {
                            logger.error("IOException" + e);
                            break;
                        }
                    }
                }).start();

                //Отправка сообщения
                while (true) {
                    String line = console.nextLine();
                    out.println(line);
                    if ("stop".equals(line)) {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            logger.error(e);
        }
    }

}
