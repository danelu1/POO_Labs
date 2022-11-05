import java.util.Scanner;

public class Problem5 {
	public static String censorship(String str, String[] words) {
		String[] s = str.split(" ");
		StringBuffer string = new StringBuffer();
		String answer = "";
		
		for (int i = 0; i < s.length; i++) {
			answer += s[i] + " ";
			for (int j = 0; j < words.length; j++) {
				if (s[i].equals(words[j])) {
					StringBuffer ceva = new StringBuffer(words[j]);
					String aux = "";
					for (int k = 1; k < ceva.length() - 1; k++) {
						aux += "*";
					}
					string = ceva.replace(1, ceva.length() - 1, aux);
					answer = answer.replaceAll(s[i], "");
					answer += string.toString() + " ";
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int size = scanner.nextInt();
		String[] words = new String[size];
		for (int i = 0; i < size; i++) {
			words[i] = scanner.nextLine();
		}
		
		System.out.println(censorship(str, words));
	}
}
