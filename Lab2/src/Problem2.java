import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem2 {
	public static int other_count(String s1, String s2) {
		int cnt = 0;
		StringTokenizer str = new StringTokenizer(s1, ".?:- ");
		while (str.hasMoreTokens()) {
			if (str.nextToken().equals(s2)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static int count(String s1, String s2) {
		int cnt = 0;
		String[] words = s1.split(" ");
		
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(s2)) {
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
		System.out.println(other_count(s1, s2));
	}
}
