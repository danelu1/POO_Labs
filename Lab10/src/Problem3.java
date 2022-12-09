import java.util.*;

abstract class AMatrix<T extends Number> extends ArrayList<ArrayList<T>> {
	private static final long serialVersionUID = 1L;

	public abstract AMatrix<T> addition(AMatrix<T> m1);
	
	public abstract T sum(T obj1, T obj2);
}

@SuppressWarnings({ "rawtypes" })
class IntegerMatrix extends AMatrix<Integer> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public AMatrix addition(AMatrix m1) {
		Integer value = null;
		Integer num = null;
		Number res = null;
		AMatrix ans = new IntegerMatrix();
		Iterator<ArrayList<Integer>> it = iterator();
		Iterator<ArrayList<Integer>> matrix_iterator = m1.iterator();
		
		while (it.hasNext() && matrix_iterator.hasNext()) {
			Iterator<Integer> it_aux = it.next().iterator();
			Iterator<Integer> itr = matrix_iterator.next().iterator();
			ArrayList<Number> line = new ArrayList<>();
			
			while (it_aux.hasNext() && itr.hasNext()) {
				value = it_aux.next();
				num = itr.next();
				res = this.sum(value, num);
				line.add(res);
			}
			ans.add(line);
		}
		
		return ans;
	}
	
	public String toString() {
		String ans = "";
		
		for (int i = 0; i < size(); i++) {
			ans += get(i);
			ans += "\n";
		}
		
		return ans;
	}

	@Override
	public Integer sum(Integer obj1, Integer obj2) {
		int num1 = (int) obj1;
		int num2 = (int) obj2;
		return num1 + num2;
	}
}

class Test {
	public static void main(String[] args) {
		AMatrix<Integer> a = new IntegerMatrix();
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		
		list1.add(1);
		list1.add(1);
		list1.add(1);
		
		list2.add(2);
		list2.add(2);
		list2.add(2);
		
		list3.add(3);
		list3.add(3);
		list3.add(3);
		
		a.add(list1);
		a.add(list2);
		a.add(list3);
		
		System.out.println(a);
		
		AMatrix<Integer> b = new IntegerMatrix();
		
		ArrayList<Integer> list4 = new ArrayList<>();
		ArrayList<Integer> list5 = new ArrayList<>();
		ArrayList<Integer> list6 = new ArrayList<>();
		
		list4.add(1);
		list4.add(1);
		list4.add(1);
		
		list5.add(2);
		list5.add(2);
		list5.add(2);
		
		list6.add(3);
		list6.add(3);
		list6.add(3);
		
		b.add(list4);
		b.add(list5);
		b.add(list6);
		
		System.out.println(b);
		
		System.out.println(a.addition(b));
	}
}