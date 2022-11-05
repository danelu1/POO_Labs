import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

public class Problem3 {
	public static int eliminate(Vector<Integer> vector, int x) {
		int cnt = 0;
		for (int i = 0; i < vector.size(); i++) {
			if (vector.get(i).equals(x)) {
				cnt++;
				vector.removeElementAt(i);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> vector = new Vector<Integer>();
		Random random = new Random();
		
		for (int i = 0; i < 20; i++) {
			vector.add(random.nextInt(11));
		}
		System.out.println(vector);
		
		int x = scanner.nextInt();
		System.out.println(eliminate(vector, x));
		System.out.println(vector);
		
		int max = vector.get(0);
		for (int i = 0; i < vector.size(); i++) {
			if (vector.get(i) > max) {
				max = vector.get(i);
			}
		}
		System.out.println(max);
		
		int sum = 0;
		for (int i = 0; i < vector.size(); i++) {
			sum += vector.get(i);
		}
		System.out.println((double) sum / vector.size());
		
		int min = vector.get(0);
		Vector<Integer> indexes = new Vector<Integer>();
		for (int i = 0; i < vector.size(); i++) {
			if (vector.get(i) < min) {
				min = vector.get(i);
				indexes.add(i);
			}
		}
		System.out.println(min);
		System.out.println(indexes.get(indexes.size() - 1));
	} 

}
