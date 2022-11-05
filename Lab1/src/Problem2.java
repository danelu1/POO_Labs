import java.util.Scanner;

class Task {
	public String print(String str) {
		return str;
	}
}

class Problem2 {
	public String print(String str) {
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		Problem2 obiect = new Problem2();
		System.out.println(obiect.print(str));
		String str_aux = scanner.nextLine();
		Task obiect_aux = new Task();
		System.out.println(obiect_aux.print(str_aux));
	}
}