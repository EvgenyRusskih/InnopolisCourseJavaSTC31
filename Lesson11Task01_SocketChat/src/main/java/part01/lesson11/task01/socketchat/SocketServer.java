package part01.lesson11.task01.socketchat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Socket server
 * Listening socket port for client (port number -should be free)
 */
public class SocketServer {

    /**
     * Logger log4g
     * Socket port number for client listening (should be free)
     * flag is listen port
     * list connections clients
     */
    private static final Logger logger = LogManager.getLogger(SocketServer.class);
    private static final int port = 51111;
    private static boolean flagListenPort = true;
    private static Map<String, Socket> connects = new HashMap<>();


    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        socketServer.startServer();
    }


    private void startServer() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            logger.info("Socket server starting ...");
            logger.info("Listening port: " + port);
        } catch (IOException e) {
            logger.error("Socket error: " + e);
        }
        while (flagListenPort) {
            Socket socket = null;
            try {
                assert serverSocket != null;
                socket = serverSocket.accept();
            } catch (IOException e) {
                logger.error("Socket error accept:" + e);
                break;
            }

            Socket finalSocket = socket;
            new Thread(() -> {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(finalSocket.getInputStream()));
                } catch (IOException e) {
                    logger.error(e);
                }
                String message = null;
                try {
                    assert reader != null;
                    message = reader.readLine();
                } catch (IOException e) {
                    logger.error(e);
                }
                logger.info("Connect client: " + message);
                // Load connect to map
                synchronized (SocketServer.class) {
                    connects.put(message, finalSocket);
                }

                // Слушаем порт и принимаем сообщение от клиента
                while (finalSocket.isConnected()) {
                    try {
                        String line = reader.readLine();
                        if (line == null) continue;
                        logger.info(message + " отправил: " + line);
                        sendMsg(message, line);
                    } catch (IOException e) {
                        logger.error(e);
                        break;
                    }
                }
            }).start();
        }
    }


    private void sendMsg(String connect, String msg) throws IOException {
        for (Map.Entry<String, Socket> entry : connects.entrySet()) {
            //не можем отправить самому себе
            if (!connect.equals(entry.getKey())) {
                Socket clientSocket = entry.getValue();
                if (clientSocket.isConnected()) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println(connect + " message from client: " + msg);
                }
            }
        }

    }

}
