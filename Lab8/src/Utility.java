import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Utility {

    public static void paddingBytesArray(byte[] dest, int newSize, byte[] src, int size) {
	    for (int i = 0; i < size; i++) {
		    dest[i] = src[i];
	    }
	    for (int i = size; i < newSize; i++) { // fill null character
		    dest[i] = 0;
	    }
    }
    
    /*public static String getReceivedString(byte[] src) {
 		int index;
 	    char[] tempCharData = new char[src.length];
 		for (index = 0; index < src.length; index++) {
 			if (src[index] != 0)
 				tempCharData[index] = (char) src[index];
 			else 
 				break;  // null character is hit			
 		}
 		String s = new String(tempCharData, 0, index);
 		return s;
 	}*/
    
    public static String getReceivedString(byte[] src) {
    	int index = 0;
 		while (index < src.length) {
 			if (src[index] == 0) break; // null character is hit
 			index++;
 		}
 		String s = new String(src, 0, index);
 		return s;
 	}
    
    public static byte[] convertIntegerToByteArray(int size, int data) throws IOException {
    	ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeInt(data);
        byte[] sizeBuffer = baos.toByteArray();
		baos.close();
        return sizeBuffer;
    }
    
    public static int convertByteArrayToInteger(byte[] intBuffer) throws IOException {
    	DataInputStream dis = new DataInputStream(new ByteArrayInputStream(intBuffer));
        int value = dis.readInt();
        return value;
    }
    
    public static byte[] convertImageFileToByteArray(String filename) throws IOException {
    	BufferedImage image = ImageIO.read(new File(filename));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String format = filename.substring(filename.lastIndexOf('.') + 1);
		ImageIO.write(image, format, baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
    }
    
    public static void convertByteArrayToImageFile(byte[] imageInByte, String filename) throws IOException {
 		InputStream is = new ByteArrayInputStream(imageInByte);
 		BufferedImage image = ImageIO.read(is);
		String format = filename.substring(filename.lastIndexOf('.') + 1);
 		ImageIO.write(image, format, new File(filename));
 		System.out.println("image " + image.getHeight() + "x" + image.getWidth() + ": " + filename);
	}
    
    public static byte[] convertImageToByteArray(BufferedImage image, String format) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, format, baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
    }

    public static BufferedImage convertByteArrayToImage(byte[] imageInByte) throws IOException {
    	InputStream is = new ByteArrayInputStream(imageInByte);
    	BufferedImage image = ImageIO.read(is);
    	return image;
    }
    
    public static byte[] convertFileToByteArray(String filename) throws IOException {
    	File file = new File(filename);
    	byte[] dataInByte = new byte[(int)file.length()];
    	FileInputStream fis = new FileInputStream(file);
    	fis.read(dataInByte);
    	return dataInByte;
    }
    
    public static void  convertFileToByteArray(byte[] dataInByte , String fullpath) throws IOException {
    	FileOutputStream fos = new FileOutputStream(fullpath);
    	fos.write(dataInByte);
    }
 
}
