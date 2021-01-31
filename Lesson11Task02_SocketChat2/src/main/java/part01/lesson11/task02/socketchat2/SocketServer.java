package part01.lesson11.task02.socketchat2;

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
        try {
            socketServer.startServer();
        } catch (IOException e) {
            logger.error("IO exception "+e);
        }
    }


    private void startServer() throws IOException {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(port);
        logger.info("Socket server starting: OK ");
        logger.info("Listening port: " + port);

        while (flagListenPort) {
            assert serverSocket != null;
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } catch (IOException e) {
                    logger.error(e);
                }
                String clientName = null;
                try {
                    assert reader != null;
                    clientName = reader.readLine();
                } catch (IOException e) {
                    logger.error(e);
                }
                logger.info("Connect client: " + clientName);
                // Load connect to map
                synchronized (SocketServer.class) {
                    connects.put(clientName, socket);
                }

                // Слушаем порт и принимаем сообщение от клиента
                // Проверяем начало сообщения для unicast
                while (socket.isConnected()) {
                    try {
                        String line = reader.readLine();
                        if (line == null) continue;
                        if(line.equals("stop")) {
                            logger.info(clientName+" connect reset ");
                            socket.close();
                            break;
                        }
                        logger.info(clientName + " отправил: " + line);
                        // проверка если сообщение unicast
                        // получатель в начале сообщения и разделен пробелом
                        if(checkUniCastMsg(line)) {
                            String name = line.substring(0, line.indexOf(' '));
                            String msg = line.substring(line.indexOf(' ') + 1);
                            sendMsgUnicast(clientName, name, msg);
                        } else {
                            sendMsgBroadcast(clientName, line);
                        }

                    } catch (IOException e) {
                        logger.error(e);
                        break;
                    }
                }
            }).start();
        }
    }


    private static boolean checkUniCastMsg(String msg) {
        for (String name : connects.keySet()) {
            if (msg.startsWith(name)) return true;
        }
        return false;
    }

    private static void sendMsgUnicast(String sender, String clientName, String msg) throws IOException {
        Socket clientSocket = connects.get(clientName);
        if (clientSocket.isConnected()) {
            PrintWriter outsocket = new PrintWriter(clientSocket.getOutputStream(), true);
            outsocket.println(sender + " you personal message: " + msg);
        }
    }


    private void sendMsgBroadcast(String connect, String msg) throws IOException {
        for (Map.Entry<String, Socket> entry : connects.entrySet()) {
            //не можем отправить самому себе
            if (!connect.equals(entry.getKey())) {
                Socket clientSocket = entry.getValue();
                if (clientSocket.isConnected()) {
                    PrintWriter outsocket = new PrintWriter(clientSocket.getOutputStream(), true);
                    outsocket.println(connect + " message all clients: " + msg);
                }
            }
        }

    }

}
