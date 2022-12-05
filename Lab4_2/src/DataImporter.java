import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// https://data.kma.go.kr/data/grnd/selectAsosRltmList.do?pgmNo=36
// WeatherDataImporter (KPARK 2019/09/10)
public class DataImporter{

	// load CSV
    public static List<WeatherData> loadCSV(String filename) {
    	 int index = 0;
    	 List<WeatherData> data=new ArrayList<WeatherData>();
    	 try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
    	 {
    		 String line="";
    		 String delimiter = ",";
    		
    		 while ((line = br.readLine()) != null)
    		 {
             	if (line.contains("#")) 
             	{
             		System.out.println("line contains #: " + line);
             		continue;
             	}
             	 String[] items = line.split(delimiter);
                 Date dateTime = null;
                 double temperature=0;
             	 double relativeHumidity=0;
             	 try
             	 {
             		temperature = Double.parseDouble(items[0]);
             		relativeHumidity=Double.parseDouble(items[1]);
             	 }
             	catch (Exception e) {
        			e.printStackTrace();
        		 }
             	WeatherData weather = new WeatherData(temperature, relativeHumidity);
             	if (weather != null)  data.add(weather);    
             }
    		 }
    	 catch(FileNotFoundException e1) 
    	 {
    		 e1.printStackTrace(); 
    	 }
    	 catch(IOException e1)
    	 {
    		 
			 e1.printStackTrace();
		 }
    	 System.out.println("load successfully");
		 return data;
    }
    
    // save CSV
    public static void saveCSV(String filename, List<? extends WeatherData> data)  {
    	FileWriter fw;
		try {
            System.out.println("file save: " + filename);

			fw = new FileWriter(filename);
	        for (WeatherData d : data) {
				System.out.println(d);
	            fw.append(d.toString() + "\n");
	        }
	        fw.flush();
	        fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    
    }
}