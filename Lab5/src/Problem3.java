import java.util.Vector;
import java.util.Collections;
import java.util.Scanner;

class ExceptieNumarNegativ extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptieNumarNegativ(String message) {
		super(message);
	}
}

class Problem3 {
	private Vector<Integer> v;
	
	public Problem3() {
		v = new Vector<>();
	}
	
	public void myRead() throws ExceptieNumarNegativ {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		while (num >= 0) {
			v.add(num);
			num = scanner.nextInt();
		}
		System.out.println(v);
		System.out.println(Collections.max(v));
		
		if (num < 0) {
			throw new ExceptieNumarNegativ("Numarul introdus este negativ!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try {
			Problem3 obj = new Problem3();
			obj.myRead();
		} catch (ExceptieNumarNegativ e) {
			System.out.println(e.getMessage());
		}
	}
}
