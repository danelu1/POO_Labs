import java.util.Vector;

class Produs {
	String name;
	double price;
	int quantity;
	
	public Produs(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String toString() {
		String ans = "";
		ans += "Produs " + name + " " + price + " " + quantity;
		return ans;
	}
	
	public double getTotalProdus() {
		return price * quantity;
	}
}

class Magazin {
	String name;
	Vector<Produs> v;
	
	public Magazin(String name, String[] names, double[] prices, int[] quantities) {
		this.name = name;
		v = new Vector<>();
		
		for (int i = 0; i < names.length; i++) {
			v.add(new Produs(names[i], prices[i], quantities[i]));
		}
	}
	
	public String toString() {
		String ans = "";
		ans += "Magazin " + name + " :";
		ans += "\n"; 
		for (int i = 0; i < v.size(); i++) {
			ans += v.get(i).toString();
			ans += "\n";
		}
		return ans;
	}
	
	public double getTotalMagazin() {
		double rez = 0;
		for (int i = 0; i < v.size(); i++) {
			rez += v.get(i).getTotalProdus();
		}
		return rez;
	}
}

class Problem2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produs p = new Produs("Ariel", 49.99, 3);
		System.out.println(p);
		System.out.println(p.getTotalProdus());
		String[] names = { "Perwoll", "Lipici", "Covalact" };
		double[] prices = { 80, 15, 10 };
		int[] quantities = { 2, 1, 3 };
		Magazin m = new Magazin("Selgros", names, prices, quantities);
		System.out.println(m);
		System.out.println(m.getTotalMagazin());
	}
}
