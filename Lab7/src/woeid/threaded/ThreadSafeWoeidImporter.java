package woeid.threaded;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import woeid.WOEID;

public class ThreadSafeWoeidImporter {
	 List<WOEID> list = Collections.synchronizedList(new ArrayList()); 
	
	 public  synchronized List<WOEID> loadCSV(String filename) {      
	        String line = "";
	        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	            String delimiter = ",";
	            while ((line = br.readLine()) != null) {
	                String[] items = line.split(delimiter);
	                WOEID woeid = null;
	                long id =  Long.parseLong(items[0]);
	                String city = items[1];
	                String country = items[2];
	                double latitude = Double.parseDouble(items[3]);
	                double longtitude = Double.parseDouble(items[4]);
	                woeid = new WOEID(id, city, country, latitude, longtitude);
	               	if (woeid != null) list.add(woeid);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			System.out.println(Thread.currentThread().getName()+"load successfully");
			return list; // data.toArray(new Person[data.size()]);
	    }
	    
	    // save CSV
	    public static synchronized void saveCSV(String path, List<? extends WOEID> data) {
	    	FileWriter fw;
			try {
	            System.out.println("file save: " + path);

				fw = new FileWriter(path);
		        for (WOEID d : data) {
					System.out.println(d);
		            fw.append(d.toString() + "\n");
		        }
		        fw.flush();
		        fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

	
}
