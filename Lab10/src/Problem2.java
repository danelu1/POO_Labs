import java.util.*;

class ArrayMap<K, V> extends AbstractMap<K, V> {
	Vector<K> keys;
	Vector<V> values;
	
	public ArrayMap() {
		keys = new Vector<>();
		values = new Vector<>();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Entry<K, V>> entries = new LinkedHashSet<>();
		
		for (int i = 0; i < keys.size(); i++) {
			entries.add(new ArrayMapEntry<K, V>(keys.get(i), values.get(i)));
		}
		
		return entries;
	}
	
	public V put(K key, V value) {
		if (!containsKey(key)) {
			keys.add(key);
			values.add(value);
			return null;
		} else {
			V v = get(key);
			int index = keys.indexOf(key);
			values.remove(index);
			values.add(index, value);
			return v;
		}
	}
	
	@SuppressWarnings("unchecked")
	public V get(Object o) {
		K key = (K) o;
		int index = keys.indexOf(key);
		
		return values.get(index);
	}
	
	public Set<K> keySet() {
		Set<K> entry_keys = new LinkedHashSet<>();
		
		for (int i = 0; i < keys.size(); i++) {
			entry_keys.add(keys.get(i));
		}
		
		return entry_keys;
	}
	
	public Collection<V> values() {
		Collection<V> entry_values = new LinkedHashSet<>();
		
		for (int i = 0; i < values.size(); i++) {
			entry_values.add(values.get(i));
		}
		
		return entry_values;
	}
	
	public String toString() {
		String ans = "{ ";
		
		for (int i = 0; i < keys.size(); i++) {
			ArrayMapEntry<K, V> entry = new ArrayMapEntry<>(keys.get(i), values.get(i));
			ans += entry + " ";
		}
		ans += "}";
		
		return ans;
	}
	
	@SuppressWarnings("hiding")
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
		
		@SuppressWarnings("unchecked")
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

class Main {
	public static void main(String[] args) {
		ArrayMap<String, Integer> map = new ArrayMap<>();
		
		map.put("Andrei", 23);
		map.put("Ramon", 20);
		map.put("Cornelia", 16);
		System.out.println(map);
		
		map.put("Andrei", 12);
		System.out.println(map);
		
		map.put("Cornelia", 2);
		System.out.println(map);
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}