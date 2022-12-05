package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataImporter<T> {
	
	Parser<T> parser = null;

	public DataImporter(Parser parser) {
		this.parser = parser;
	}
	
	public <T> List<T> loadCSV(String filename){
    	 List<T> data=new ArrayList<T>();
    	
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
             if (parser.parse(items) != null) 
              data.add((T)parser.parse(items));    
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
	
	public void saveCSV(String path, List<?> data) {
		FileWriter fw;
		try {
            System.out.println("file save: " + path);
			fw = new FileWriter(path);
	        for (Object d : data) {
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
