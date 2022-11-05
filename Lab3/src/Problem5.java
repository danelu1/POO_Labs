class Punct {
	private int abscisa;
	private int ordonata;
	
	public Punct() {
		abscisa = 0;
		ordonata = 0;
	}
	
	public int getX() {
		return abscisa;
	}
	
	public void setX(int x) {
		abscisa = x;
	}
	
	public int getY() {
		return ordonata;
	}
	
	public void setY(int y) {
		ordonata = y;
	}
	
	public String toString() {
		String ans = "";
		ans += "(" + abscisa + "," + ordonata + ")";
		return ans;
	}
	
	public double distance(int x, int y) {
		return Math.sqrt((abscisa - x) * (abscisa - x) + (ordonata - y) * (ordonata - y));
	}
	
	public double distance(Punct p) {
		double rez = 0;
		rez = Math.sqrt((abscisa - p.abscisa) * (abscisa - p.abscisa) + (ordonata - p.ordonata) * (ordonata - p.ordonata));
		return rez;
	}
}

class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punct p = new Punct();
		p.setX(1);
		p.setY(2);
		System.out.println(p);
		Punct p1 = new Punct();
		p1.setX(-1);
		p1.setY(3);
		System.out.println(p1);
		System.out.println(p.distance(-1, 3));
		System.out.println(p.distance(p1));
	}

}
