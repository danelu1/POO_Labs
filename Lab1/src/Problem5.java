import java.util.Scanner;

public class Problem5 {
	public double power(int base, int exp) {
		if (exp == 0) {
			return 1;
		}
		if (exp > 0) {
			return base * power(base, exp - 1);
		}
		return 1 / (power(base, -exp));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int baza = scanner.nextInt();
		int exponent = scanner.nextInt();
		Problem5 result = new Problem5();
		System.out.println(result.power(baza, exponent));
	}
}