import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SListSet<E> extends LinkedList<Object> implements SortedSet<Object> {
	Comparator<Object> cmp;
	
	public SListSet() {
		this(null);
	}
	
	public SListSet(Comparator<Object> cmp) {
		this.cmp = cmp;
	}
	
	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		if (!contains(e)) {
			super.add(e);
			super.sort(cmp);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparator<? super Object> comparator() {
		// TODO Auto-generated method stub
		return cmp;
	}

	@Override
	public SortedSet<Object> subSet(Object fromElement, Object toElement) {
		// TODO Auto-generated method stub
		SListSet<Object> ans = new SListSet<>();
		int start_index = indexOf(fromElement);
		int end_index = indexOf(toElement);
		Iterator<Object> it = iterator();
		Object obj = last();
		int index = indexOf(obj);
		while (it.hasNext()) {
			ans.add(it.next());
		}
		
		for (int i = 0; i < start_index; i++) {
			ans.remove(get(i));
		}
		
		for (int i = end_index; i < index; i++) {
			ans.remove(get(i));
		}
		return ans;
	}

	@Override
	public SortedSet<Object> headSet(Object toElement) {
		// TODO Auto-generated method stub
		return subSet(first(), toElement);
	}

	@Override
	public SortedSet<Object> tailSet(Object fromElement) {
		// TODO Auto-generated method stub
		return subSet(fromElement, last());
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return getFirst();
	}

	@Override
	public Object last() {
		// TODO Auto-generated method stub
		return getLast();
	}
	
}

class Problem3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SListSet<String> sls = new SListSet<>();
			File file = new File("test01.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				sls.add(scanner.next());
			}
			Iterator<Object> it = sls.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
			System.out.println();
			SListSet<String> sls1 = new SListSet<>(Collections.reverseOrder());
			File file1 = new File("test01.txt");
			Scanner scanner1 = new Scanner(file1);
			while (scanner1.hasNext()) {
				sls1.add(scanner1.next());
			}
			Iterator<Object> it1 = sls1.iterator();
			while (it1.hasNext()) {
				System.out.print(it1.next() + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
		SListSet<String> sls = new SListSet<>();
		sls.add(5);
		sls.add(3);
		sls.add(12);
		sls.add(21);
		sls.add(4);
		sls.add(2);
		sls.add(5);
		sls.add(23);
		sls.add(1);
		System.out.println(sls);
		System.out.println(sls.subSet(3, 23));
	}
}
