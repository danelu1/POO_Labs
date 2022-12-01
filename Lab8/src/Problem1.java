import java.util.*;

class ArrayMap<K, V> extends AbstractMap<K, V> {
	ArrayList<ArrayMapEntry<K, V>> list;
	
	public ArrayMap() {
		list = new ArrayList<>();
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Entry<K, V>> map = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			map.add(list.get(i));
		}
		return map;
	}
	
	public int size() {
		return super.size();
	}
	
	public V put(K key, V value) {
		ArrayMapEntry<K, V> new_entry = new ArrayMapEntry<K, V>(key, value);
		if (!containsKey(key)) {
			list.add(new_entry);
			return null;
		} else {
			V v = get(key);
			ArrayMapEntry<K, V> old_entry = new ArrayMapEntry<>(key, v);
			int index = list.indexOf(old_entry);
			list.get(index).setValue(value);
			return v;
		}
	}
	
	class ArrayMapEntry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		
		public ArrayMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V v) {
			// TODO Auto-generated method stub
			if (value != v) {
				value = v;
			}
			return value;
		}
		
		public String toString() {
			String ans = "";
			ans += key + "=" + value;
			return ans;
		}
		
		public boolean equals(Object o) {
			ArrayMapEntry<K, V> entry = (ArrayMapEntry<K, V>) o;
			if (entry.getKey() == key && entry.getValue() == value) {
				return true;
			}
			return false;
		}
		
		public int hashCode() {
			if (this.getKey() == null ^ this.getValue() == null) {
				return 0;
			} else {
				return this.getKey().hashCode() ^ this.getValue().hashCode();
			}
		}
	}
}

class Task1 {

    public static void main(String args[]) {
        ArrayMap<Integer, String> map = new ArrayMap<>();

        System.out.println("Populam colectia...");
        map.put(7, "Colectii si genericitate");
        map.put(8, "Clase interne");
        map.put(5, "Fluxuri");

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + map);

        if (map.size() != 3) {
            System.err.println("ArrayMap.size() (" + map.size() + ") a fost implementata gresit.");
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        if (entries.size() != 3) {
            System.err.println("ArrayMap.entrySet() a fost implementata gresit.");
        }

        for (Map.Entry<Integer, String> e : entries) {
            map.put(e.getKey(), new StringBuffer(e.getValue()).reverse().toString());
            if (!map.entrySet().contains(e)) {
                System.err.println("ArrayMap.put() nu inlocuieste vechea valoare.");
            }
            if ((!e.toString().contains(e.getKey().toString()) || (!e.toString().contains(e.getValue())))) {
                System.err.println("ArrayMap.ArrayMapEntry.toString() a fost implementata gresit.");
            }
        }

        for (Map.Entry<Integer, String> e1 : entries) {
            for (Map.Entry<Integer, String> e2 : entries) {
                if ((e1 == e2) != (e1.equals(e2))) {
                    System.err.println("ArrayMap.ArrayMapEntry.equals() a fost implementata gresit.");
                }
                if ((e1 == e2) != (e1.hashCode() == e2.hashCode())) {
                    System.err.println("ArrayMap.ArrayMapEntry.hashCode() a fost implementata gresit.");
                }
            }
        }
        System.out.println(map);
    }
}
