import java.util.*;

class HSet<E> extends Hashtable<Object, Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean add(Object value) {
		if (!contains(value)) {
			put(value, value);
			return true;
		}
		return false;
	}
	
	public Object remove(Object key) {
		return super.remove(key);
	}
	
	public String toString() {
		String ans = "";
		ans += "{ ";
		Iterator<Object> it = keySet().iterator();
		while (it.hasNext()) {
			ans += it.next() + " ";
		}
		ans += "}";
		return ans;
	}
}

class Test3 {
    public static void main(String args[]) {
        HSet<Integer> set = new HSet<Integer>();
        set.add("Laborator");
        set.add("Agregare");
        set.add("Mostenire");
        System.out.println(set);
        System.out.println(set.size());
        set.add("Laborator");
        if(set.size() == 4) {
            System.out.println("Multimea nu trebuie sa contina duplicate!");
        }
        System.out.println(set.remove("POO"));
        System.out.println(set.remove("Laborator"));
        if(set.size() != 2) {
            System.out.println("Stergerea nu functioneaza!");
        }
        set.add("Supradefinire");
        set.add("Supraincarcare");
        System.out.println(set);
    }
}
