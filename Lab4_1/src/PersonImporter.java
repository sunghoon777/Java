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
public class PersonImporter {

	// load CSV
    public static List<Person> loadCSV(String filename) {
    	 int index = 0;
    	 List<Person> data=new ArrayList<Person>();
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
             	 int age=0;
             	 Gender gender =null;
             	 double weight=0,height=0,neck=0,waist=0,hip=0;
             	 Activity activity = null;
             	 try
             	 {
             		age=Integer.parseInt(items[1]);
             	    gender= Gender.valueOf(items[2]);
             		weight = Double.parseDouble(items[3]);
                	height = Double.parseDouble(items[4]);
                	neck = Double.parseDouble(items[5]);
                	waist = Double.parseDouble(items[6]);
                	hip = Double.parseDouble(items[7]);
                	activity = Activity.valueOf(items[8]);	 
             	 }
             	catch (Exception e) {
        			e.printStackTrace();
        		 }
             	Person person = new Person(age,gender,weight,height,neck, waist,hip,activity);
             	if (person != null)  data.add(person);    
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
    public static void saveCSV(String filename, List<? extends Person> data)  {
    	FileWriter fw;
		try {
            System.out.println("file save: " + filename);

			fw = new FileWriter(filename);
	        for (Person d : data) {
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