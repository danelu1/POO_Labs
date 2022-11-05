class Numar {
	int nr;
	
	public Numar(int nr) { 
		this.nr = nr;
	}
	
	public int suma(int a) {
		return nr + a;
	}
	
	public int suma(int a, int b) {
		return b + suma(a);
	}
	
	public int suma(int a, int b, int c) {
		return c + suma(a, b);
	}
	
	public int suma(int a, int b, int c, int d) {
		return d + suma(a, b, c);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numar numar = new Numar(10);
		System.out.println(numar.suma(1));
		System.out.println(numar.suma(1, 2));
		System.out.println(numar.suma(1, 2, 3));
		System.out.println(numar.suma(1, 2, 3, 4));
	}
}
