import java.util.InputMismatchException;
import java.util.UnknownFormatConversionException;

public class Utility {
	public static double getDouble(String str) {
		double value = 0.0;
		if (str.isEmpty()) return value;
		
		try {
			value = Double.parseDouble(str);
		}
		catch (InputMismatchException e) {
 			System.out.println("InputMismatchException!");
 		}
		catch (UnknownFormatConversionException e) {
			System.out.println("UnknownFormatConversionException!");
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatException!");
 		}
		catch (Exception e) {
			System.out.println("Exception!");
 		}
		return value;
	}
	
	public static int getInt(String str) {
		int value = 0;
		if (str.isEmpty()) return value;
		
		try {
			value = Integer.parseInt(str);
		}
		catch (InputMismatchException e) {
 			System.out.println("InputMismatchException!");
 		}
		catch (UnknownFormatConversionException e) {
			System.out.println("UnknownFormatConversionException!");
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatException!");
 		}
		catch (Exception e) {
			System.out.println("Exception!");
 		}
		return value;
	}
	
	public static Gender getGender(String str) {
		Gender value = null;
		if (str.isEmpty()) return value;
		
		try {
			value = Gender.valueOf(str);
		}
		catch (InputMismatchException e) {
 			System.out.println("InputMismatchException!");
 		}
		catch (UnknownFormatConversionException e) {
			System.out.println("UnknownFormatConversionException!");
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatException!");
 		}
		catch (Exception e) {
			System.out.println("Exception!");
 		}
		return value;
	}
	
	public static Activity getActivity(String str) {
		Activity value = null;
		if (str.isEmpty()) return value;
		
		try {
			value = Activity.valueOf(str);
		}
		catch (InputMismatchException e) {
 			System.out.println("InputMismatchException!");
 		}
		catch (UnknownFormatConversionException e) {
			System.out.println("UnknownFormatConversionException!");
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatException!");
 		}
		catch (Exception e) {
			System.out.println("Exception!");
 		}
		return value;
	}
	
	public static BMI getBMI(String str) {
		BMI value = null;
		if (str.isEmpty()) return value;
		
		try {
			value = BMI.valueOf(str);
		}
		catch (InputMismatchException e) {
 			System.out.println("InputMismatchException!");
 		}
		catch (UnknownFormatConversionException e) {
			System.out.println("UnknownFormatConversionException!");
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatException!");
 		}
		catch (Exception e) {
			System.out.println("Exception!");
 		}
		return value;
	}
}
