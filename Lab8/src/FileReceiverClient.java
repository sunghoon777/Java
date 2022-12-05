import java.io.IOException;

public class FileReceiverClient implements Runnable {
TCPClient client = null;
	
	static final int SIZE_OF_FILENAME = 256;
    static final int SIZE_OF_INT = 4;
    byte[] nameBuffer = new byte[SIZE_OF_FILENAME]; // (1) image name
    byte[] sizeBuffer = new byte[SIZE_OF_INT]; // (2) image size
    byte[] FileInByte = null; // (3) image buffer

	static String directory = "C:/JAVA";

	public FileReceiverClient(TCPClient c, String dir) {
		client = c;
		directory = dir;
	}

	@Override
	public void run() {
		System.out.println(getClass().getName() + " run()");
		if (client != null) {
	    	try {
	    		int numFiles = 0;
	    		int nread = client.read(sizeBuffer, SIZE_OF_INT, true);
	    		if (nread == SIZE_OF_INT) {
	    			numFiles = Utility.convertByteArrayToInteger(sizeBuffer); // (0) # of images
	    		}
	    		System.out.println(Thread.currentThread().getName() + " numFiles = " + numFiles);
	    		for (int i = 0; i < numFiles; i++) {
	    			String filename = "";
	    			int FileSize = 0;
	    			nread = client.read(nameBuffer, SIZE_OF_FILENAME, true);
	    			if (nread == SIZE_OF_FILENAME) {
	    				filename = Utility.getReceivedString(nameBuffer);
	    				System.out.println(Thread.currentThread().getName() + " filename = " + filename);
	    			}
	    			nread = client.read(sizeBuffer, SIZE_OF_INT, true);
	    			if (nread == SIZE_OF_INT) {
	    				FileSize = Utility.convertByteArrayToInteger(sizeBuffer);
	    			}
	    			if (FileSize > 0) {
	    				System.out.println(Thread.currentThread().getName() + " size = " + FileSize);
	    				FileInByte = new byte[FileSize];
	    				nread = client.read(FileInByte, FileSize, true);
	    				//System.out.println("Reading: " + System.currentTimeMillis());
	    				Utility.convertByteArrayToImageFile(FileInByte, directory + "/" + filename);
	    			}
	    		}
	    		client.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }
	}
}
