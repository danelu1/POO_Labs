import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Vector;

public class Problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Object> v = new Vector<Object>();
		v.add(1);
		v.add(2);
		v.add("String");
		v.add("Something");
		v.add(3);
		v.add(4);
		v.add(false);
		v.add('c');
		v.add(0.4f);
		v.add(0.343D);
		v.add(0.45D);
		v.add(123213L);
		v.add("Mama");
		v.add(false);
		v.add(true);
		
		Map<Object, Integer> map = new LinkedHashMap<>();
		
		for (int i = 0; i < v.size(); i++) {
			if (map.containsKey(v.get(i).getClass())) {
				map.put(v.get(i).getClass(), map.get(v.get(i).getClass()) + 1);
			} else {
				map.put(v.get(i).getClass(), 1);
			}
		}
		
		for (Map.Entry<Object, Integer> mp : map.entrySet()) {
			System.out.println(mp.getKey() + " " + mp.getValue());
		}
	}

}
