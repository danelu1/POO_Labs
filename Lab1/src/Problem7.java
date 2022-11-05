import java.util.Scanner;

public class Problem7 {
	public static boolean isPrime(int nr) {
		if (nr <= 1) {
			return false;
		}
		
		double num = (double) nr;
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void goldBach(int nr) {
		for (int i = 0; i < nr; i++) {
			if (isPrime(i) && isPrime(nr - i)) {
				int j = nr - i;
				System.out.println(nr + " = " + i + " + " + j);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nr = scanner.nextInt();
		goldBach(nr);
	}
}
