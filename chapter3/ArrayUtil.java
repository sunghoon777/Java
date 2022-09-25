package chapter3;

public class ArrayUtil {
	public static int[] concat(int[] a , int[] b) {
		int c[] = new int[a.length+b.length];
		for(int i=0;i<a.length;i++) {
			c[i] = a[i];
		}
		for(int i=a.length;i<a.length+b.length;i++) {
			c[i] = b[i-a.length];
		}
		return c;
	}
	
	public static void print(int[] a) {
		System.out.printf("[ ");
		for(int i=0;i<a.length;i++) {
			System.out.printf("%d ",a[i]);
		}
		System.out.println("]");
	}

}
