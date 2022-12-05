import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// https://data.kma.go.kr/data/grnd/selectAsosRltmList.do?pgmNo=36
// WeatherDataImporter (KPARK 2019/09/10)
public class WeatherDataImporter {
	public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	// load CSV
    public static WeatherData[] loadCSV(String filename) {      
    	WeatherData[] data = null;
        String line = "";
        // count numOfLine & create array using numOfLine
		int numOfLine = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
            	if (line.contains("#")) {
            		System.out.println("line contains #: " + line);
            		continue;
            	}
                numOfLine++;
            }
    		System.out.println("# of line:" + numOfLine);
    		data = new WeatherData[numOfLine]; // create array using # of line
            br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        // load array of data
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        	//System.out.println("file import: " + filename);
            String delimiter = ",";
            while ((line = br.readLine()) != null) {
            	if (line.contains("#")) {
            		System.out.println("line contains #: " + line);
            		continue;
            	}
                // use comma as separator
                String[] items = line.split(delimiter);
                // dateTime, temperature, windVelocity, relativeHumidity
                Date dateTime = null;
        		try {
        			dateTime = formatter.parse(items[1]);
        		} 
        		catch (ParseException e) {
        			System.out.println("ParseException!");
        		}        		
                double temperature = -1.0, windVelocity = -1.0, relativeHumidity = -1.0;
                try {
                	temperature = Double.parseDouble(items[2]);
                	windVelocity = Double.parseDouble(items[3]);
                	relativeHumidity = Double.parseDouble(items[4]);
                }
        		catch (Exception e) {
        			e.printStackTrace();
        		}

                // add data into array
                WeatherData d = new WeatherData(dateTime, temperature, windVelocity, relativeHumidity);
               	//System.out.println(d);
               	if (d != null) data[index++] = d;    
                }
            } catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        
		System.out.println("load successfully");
		return data;
    }
    
    // save CSV
    public static void saveCSV(String path, WeatherIndexCaclculator[] data) {
    	FileWriter fw;
		try {
            System.out.println("file save: " + path);

			fw = new FileWriter(path);
	        for (WeatherIndexCaclculator d : data) {
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
