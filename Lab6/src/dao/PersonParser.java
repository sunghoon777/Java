package dao;

import dto.*;

public class PersonParser implements Parser<Person> {

	@Override
	public Person parse(String[] items) {
		// TODO Auto-generated method stub
		
		int age = Integer.parseInt(items[1]);
     	Gender gender =  Gender.valueOf(items[2]);
     	double weight = Double.parseDouble(items[4]);
     	double height = Double.parseDouble(items[4]);
        double neck = Double.parseDouble(items[5]);
     	double waist = Double.parseDouble(items[6]);
     	double hip = Double.parseDouble(items[7]);
        Activity activity = Activity.valueOf(items[8]);
		return  new Person(age,gender,weight,height,neck, waist,hip,activity);
	}
	

}
