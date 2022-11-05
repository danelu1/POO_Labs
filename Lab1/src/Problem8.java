import java.util.Arrays;
import java.util.Vector;
import java.util.Scanner;

public class Problem8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		double[] vector = new double[size];
		for (int i = 0; i < size; i++) {
			vector[i] = Math.random();
		}
		
		System.out.print("Vector before sorting : ");
		for (int i = 0; i < size; i++) {
			System.out.print(vector[i] + " ");
		}
		
		System.out.println();
		Arrays.sort(vector);
		
		System.out.print("Vector after sorting : ");
		for (int i = 0; i < size; i++) {
			System.out.print(vector[i] + " ");
		}
		
		System.out.println();
		System.out.print("Element to find : " + Arrays.binarySearch(vector, vector[3]));
	}
}
