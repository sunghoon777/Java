public class ThreadedMultipleImageSenderClientTest {
	static int numThread = 1; // 20 (1/2/4/5/10/20)
	static final int NUM_FILES = 20; // # of images
	static final String dir = "C:/images";

	static String ip = "127.0.0.1";
	static int port = 9008;

	//static final int SIZE_OF_FILENAME = 256;
    //static final int SIZE_OF_INT = 4;
        
    public void run() {
		for (int i = 0; i < numThread; i++) {
			int startIndex = NUM_FILES / numThread * i;
			int endIndex = NUM_FILES / numThread * i + NUM_FILES / numThread - 1;
			FileSenderClient client = new FileSenderClient(new TCPClient(ip, port), dir, startIndex, endIndex, NUM_FILES / numThread);
			new Thread(client).start();
		}
    }
    
    public static void main(String[] args) {   	
    	if (args.length >= 1) numThread = Integer.parseInt(args[0]);
    	if (args.length >= 2) ip = args[1];
    	if (args.length >= 3) port = Integer.parseInt(args[2]);

    	ThreadedMultipleImageSenderClientTest c = new ThreadedMultipleImageSenderClientTest();
    	c.run();
    }
}
