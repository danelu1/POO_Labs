import java.util.*;
import java.io.*;

class Problem1 {
	public static TreeSet<String> printWords(String filename) throws FileNotFoundException {
		TreeSet<String> ans = new TreeSet<>();
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			ans.add(scanner.next());
		}
		return ans;
	}
	
	public static TreeSet<String> printWordsComparator(TreeSet<String> set) {
		Iterator<String> it = set.iterator();
		TreeSet<String> set_aux = new TreeSet<>(Collections.reverseOrder());
		while (it.hasNext()) {
			set_aux.add(it.next());
		}
		return set_aux;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TreeSet<String> set = printWords("test01.txt");
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
			System.out.println(printWordsComparator(set));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}