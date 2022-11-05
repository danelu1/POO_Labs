import java.util.Vector;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class Problem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> v1 = new Vector<Integer>();
		Vector<Integer> v2 = new Vector<Integer>();
		
		int size1 = scanner.nextInt();
		for (int i = 0; i < size1; i++) {
			v1.add(scanner.nextInt());
		}
		
		int size2 = scanner.nextInt();
		for (int i = 0; i < size2; i++) {
			v2.add(scanner.nextInt());
		}
		
//		Reuniunea
		
		Vector<Integer> reunion = new Vector<Integer>();
		
		Set<Integer> set1 = new LinkedHashSet<>();
		for (int i = 0; i < size1; i++) {
			set1.add(v1.get(i));
		}
		
		for (int i = 0; i < size2; i++) {
			set1.add(v2.get(i));
		}
		
		Iterator<Integer> it = set1.iterator();
		while (it.hasNext()) {
			reunion.add(it.next());
		}
		System.out.println(reunion);
		
//		Intersectia
		
		Vector<Integer> intersection = new Vector<Integer>();
		Set<Integer> set2 = new LinkedHashSet<>();
		Set<Integer> set3 = new LinkedHashSet<>();
		
		for (int i = 0; i < size1; i++) {
			set2.add(v1.get(i));
		}
		
		for (int i = 0; i < size2; i++) {
			set3.add(v2.get(i));
		}
		
		set2.retainAll(set3);
		
		Iterator<Integer> itr = set2.iterator();
		while (itr.hasNext()) {
			intersection.add(itr.next());
		}
		System.out.println(intersection);
	}
}
