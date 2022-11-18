import java.util.*;
import java.io.*;
import java.nio.file.Files;

class Problem5 {
	public static void print(String dirr) {
		File file = new File(dirr);
		File[] files = null;
		if (file.isDirectory()) {
			files = file.listFiles();
		}
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < files.length; i++) {
			map.put(files[i].getName(), (int) files[i].length());
		}
		
		for (Map.Entry<String, Integer> mp : map.entrySet()) {
			System.out.println(mp.getKey() + " " + mp.getValue());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(".");
	}
}
