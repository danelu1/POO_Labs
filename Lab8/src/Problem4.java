import java.util.*;

class Table {
	Vector<Vector<Object>> v;
	
	public Table(Object[][] rows) {
		v = new Vector<Vector<Object>>();
		
		Vector<Object> vector = new Vector<>();
		for (int i = 0; i < rows.length; i++) {
			vector.add(rows[i]);
		}
		
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length; j++) {
				v.add(vector);
			}
		}
	}
	
	public String toString() {
		String ans = "";
		for (int i = 0; i < v.size(); i++) {
			for (int j = 0; j < v.get(i).size(); j++) {
				ans += v.get(i).get(j) + " ";
			}
			ans += "\n";
		}
		return ans;
	}
}

//class Task4 {
//
//    public static void main(String[] args) {
//        Object rows[][] = new Object[][] {
//                {"#", "Materie", "An", "Semestru", "Credite"},
//                {1, "Programarea calculatoarelor", 1, 1, 6},
//                {2, "Structuri de date", 1, 2, 6},
//                {3, "Programare Orientata pe Obiecte", 2, 1, 6},
//        };
//        Table t = new Table(rows);
//        t.print(t.new CsvPrinter());
//        t.print(t.new AsciiPrinter(new int[] {2, 32, 8, 8, 8}));
//    }
//
//}
class Main {
	public static void main(String[] args) {
      Object rows[][] = new Object[][] {
    	    {"#", "Materie", "An", "Semestru", "Credite"},
      		{1, "Programarea calculatoarelor", 1, 1, 6},
      		{2, "Structuri de date", 1, 2, 6},
      		{3, "Programare Orientata pe Obiecte", 2, 1, 6},
      	};
//      	System.out.println(rows[3][1]);
		Table t = new Table(rows);
		System.out.println(t);
	}
}