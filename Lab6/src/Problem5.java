import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class Train implements Comparable<Train> {
	Vector<Vagon> vector;
	
	public Train() {
		vector = new Vector<>();
	}
	
	public void addVagon(Vagon v) {
		vector.add(v);
	}
	
	public String toString() {
		String ans = "Trenul are urmatoarele componente :\n";
		for (int i = 0; i < vector.size(); i++) {
			ans += vector.get(i) + "\n";
		}
		return ans;
	}
	
	public int numarColete() {
		int sum = 0;
		for (int i = 0; i < vector.size(); i++) {
			sum += vector.get(i).nrColete;
		}
		return sum;
	}
	
	public int compareTo(Train t) {
		if (this.numarColete() == t.numarColete()) {
			return 0;
		}
		return this.numarColete() - t.numarColete();
	}
}

abstract class Vagon {
	int nrColete;
	int nrPasageri;
	
	public Vagon(int nrPasageri, int nrColete) {
		this.nrColete = nrColete;
		this.nrPasageri = nrPasageri;
	}
	
	public abstract void printOpen();
	public abstract void printClose();
	public abstract String toString();
}

class CalatoriA extends Vagon {
	public CalatoriA() {
		super(40, 300);
	}
	
	public void printOpen() {
		System.out.println("Opening...");
	}
	
	public void printClose() {
		System.out.println("Closing...");
	}
	
	public String toString() {
		String ans = "";
		ans += "Vagon tip CalatoriA cu capacitatea de " + 40 + " de pasageri si " + 300 + " de colete";
		return ans;
	}
}

class CalatoriB extends Vagon {
	public CalatoriB() {
		super(50, 400);
	}
	
	public void printOpen() {
		System.out.println("Opening...");
	}
	
	public void printClose() {
		System.out.println("Closing...");
	}
	
	public void automaticOpen() {
		System.out.println("Touch to open");
	}
	
	public void automaticClose() {
		System.out.println("Touch to close");
	}
	
	public String toString() {
		String ans = "";
		ans += "Vagon tip CalatoriB cu capacitatea de " + 50 + " de pasageri si " + 400 + " de colete";
		return ans;
	}
}

class Marfa extends Vagon {
	public Marfa() {
		super(0, 400);
	}
	
	public void printOpen() {
		System.out.println("Pull rigth to open");
	}
	
	public void printClose() {
		System.out.println("Pull left to close");
	}
	
	public String toString() {
		String ans = "";
		ans += "Vagon tip Marfa cu capacitatea de " + 400 + " de colete";
		return ans;
	}
}

class Problema5 {
   public static void main(String args[]) {
       Train t = new Train();
       t.addVagon(new CalatoriA());
       t.addVagon(new CalatoriB());
       t.addVagon(new CalatoriA());
       t.addVagon(new CalatoriA());
       t.addVagon(new CalatoriA());
       t.addVagon(new CalatoriB());
       t.addVagon(new CalatoriB());
       t.addVagon(new Marfa());
       
       Train t1 = new Train();
       t1.addVagon(new Marfa());
       t1.addVagon(new Marfa());
       t1.addVagon(new Marfa());
       t1.addVagon(new CalatoriA());
       t1.addVagon(new CalatoriB());
       t1.addVagon(new CalatoriA());
       t1.addVagon(new CalatoriB());
       t1.addVagon(new Marfa());
       
       Train t2 = new Train();
       t2.addVagon(new CalatoriA());
       t2.addVagon(new CalatoriA());
       t2.addVagon(new CalatoriB());
       t2.addVagon(new CalatoriA());
       t2.addVagon(new CalatoriB());
       
       Vector<Train> v = new Vector<>();
       v.add(t);
       v.add(t1);
       v.add(t2);

       Collections.sort(v);
       System.out.println(v);
   }
}
