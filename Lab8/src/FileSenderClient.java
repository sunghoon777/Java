import java.io.IOException;

public class FileSenderClient  implements Runnable {
	

	TCPClient client = null;
	static final int SIZE_OF_FILENAME = 256;
    static final int SIZE_OF_INT = 4;
    byte[] nameBuffer = new byte[SIZE_OF_FILENAME]; // (1) image name
    byte[] sizeBuffer = new byte[SIZE_OF_INT]; // (2) image size
    byte[] imageInByte = null; // (3) image buffer

	static String directory = "C:/images";
    int startIndex = 0;
    int endIndex = 0;
    int numFiles = 0;
    
    public FileSenderClient(TCPClient c, String dir, int si, int ei, int num) {
        client = c;
        directory = dir;
        startIndex = si;
        endIndex = ei;
        numFiles = num;
		System.out.println(getClass().getName() + " startIndex=" + startIndex + " endIndex=" + endIndex + " numFiles=" + numFiles);
    }

	@Override
	public void run() {
		System.out.println(getClass().getName() + " run()");
        if (client != null) {
        	try {
	    		sizeBuffer = Utility.convertIntegerToByteArray(SIZE_OF_INT, numFiles); // # of files per thread
                client.write(sizeBuffer, SIZE_OF_INT, true); // # of image files
	        	for (int index = startIndex; index <= endIndex; index++) {
					String imagefile = String.format("%s/color-cam5-f0%02d.jpg", directory, index);
	        		System.out.println(Thread.currentThread().getName() + " startIndex=" + startIndex + " endIndex=" + endIndex + " index=" + index + " image=" + imagefile);
					String filename = imagefile.substring(imagefile.lastIndexOf('/') + 1);
					Utility.paddingBytesArray(nameBuffer, SIZE_OF_FILENAME, filename.getBytes(), filename.length());
					imageInByte = Utility.convertImageFileToByteArray(imagefile);
		        	sizeBuffer = Utility.convertIntegerToByteArray(SIZE_OF_INT, imageInByte.length); 
	                client.write(nameBuffer, SIZE_OF_FILENAME, true); // image filename
		        	client.write(sizeBuffer, SIZE_OF_INT, true); // image filesize
		        	client.write(imageInByte, imageInByte.length, true); // image buffer
		        	System.out.println("imagefile:" + imagefile + " byte length=" + imageInByte.length);
	        	}
	        	client.close();			        		
        	} catch (IOException e) {
    			e.printStackTrace();
    		}     	
		}
	}
	

}
