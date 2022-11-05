import java.util.Scanner;

public class Problem1 {
	public static int count(String s1, String s2) {
		int cnt = 0;
		
		for (int i = 0; i < s1.length() - s2.length(); i++) {
			if (s1.substring(i, i + s2.length()).equals(s2)) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		System.out.println(count(s1, s2));
	}
}
