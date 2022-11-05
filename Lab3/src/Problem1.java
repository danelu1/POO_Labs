import java.util.Scanner;

class Fractie {
	int up;
	int down;
	
	public Fractie(int up, int down) {
		this.up = up;
		this.down = down;
	}
	
	public Fractie() {
		this(0,0);
	}
	
	public Fractie add(Fractie f) {
		Fractie rez = new Fractie();
		rez.up = up * f.down + down * f.up;
		rez.down = down * f.down;
		return rez;
	}
	
	public String toString() {
		String ans = "";
		ans += up + "/" + down;
		return ans;
	}
	
	public boolean equals(Object obj) {
		Fractie f = (Fractie) obj;
		if (f.up * down == f.down * up) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		Fractie f1 = new Fractie(x1, y1);
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		Fractie f2 = new Fractie(x2, y2);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f1.add(f2));
		System.out.println(f1.equals(f2));
	}
}
