import java.util.Scanner;

public class Problem6 {
	public boolean isPrime(int nr) {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nr = scanner.nextInt();
		Problem6 check = new Problem6();
		System.out.println(check.isPrime(nr));
	}
}
