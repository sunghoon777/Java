//import java.io.IOException;

public class ThreadedMultipleImageReceiverServerTest {
	TCPServer server = null;
	
	static final String dir = "C:/JAVA";

    public ThreadedMultipleImageReceiverServerTest(int port) {
        server = new TCPServer(port);
    }

    public FileReceiverClient listen() {
	    TCPClient client = server.checkForNewConnections();
	    return new FileReceiverClient(client, dir);
    }
    
  
    
    public void run() {
    	while (true) {
    		FileReceiverClient client = listen();
    	    System.out.println("Server connected new client..");
    	    new Thread(client).start(); // thread for each client   			
    	}
    } 

    public static void main(String[] args) {
    	int port = 9008;
    	if (args.length >= 1) port = Integer.parseInt(args[1]);

	    ThreadedMultipleImageReceiverServerTest s = new ThreadedMultipleImageReceiverServerTest(port);
    	s.run();
    }
}
