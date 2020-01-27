import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class TCPEchoServer {

    public static final int MYPORT = 6000;
    public static int BUFSIZE = 1024;
    private String message = "Pong!";

    public static void main(String[] args) {
        try {
            byte[] buf = new byte[BUFSIZE];

            // Create server socket and bind to port.
            ServerSocket socket = new ServerSocket(MYPORT);

            // Create ExecutorService with expandable threadpool
            ExecutorService es = Executors.newCachedThreadPool();



            while (true) {
                // Accept incoming requests
                Socket incoming = socket.accept();
                // Create task to respond to client
                TCPRespondTask task = new TCPRespondTask(incoming);

                // Create separate thread for the task



            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}