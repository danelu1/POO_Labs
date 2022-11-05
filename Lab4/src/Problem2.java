import java.util.*;

class Array {
    //Vectorul in care se vor retine elementele
    private Vector<Integer> vector;
 
    //Constructor clasei
    public Array() {
        //Instantierea vectorului cu elemente
        vector = new Vector<>();
    }
 
    //Metoda care adauga un element in vector, folosind pozitia curenta
    public void addElement(Integer x) {
        vector.add(x);
    }
 
    //Metoda care adauga un element in vector, tinand cont de pozitia indicata
    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            vector.add(poz, x);
        }
    }
 
    //Metoda care returneaza elementul aflat in vector la pozitia indicata
    public int get(int poz) {
        int result;
        if(poz >= 0 && poz < vector.size()) {
            result = (int) vector.get(poz);
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }
 
    //Metoda ce intoarce numarul de elemente din vector
    public int getSize() {
        return vector.size();
    }
 
    //Metoda pentru stergerea unui element din vector
    public boolean remove(Integer x) {
        return vector.remove(x);
    }
 
    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
        return (Integer) vector.remove(pos);
    }
 
    //Metoda uzitata pentru afisarea unui obiect de tip Array
    public String toString() {
        String result = "{ ";
        for(int i = 0; i < vector.size(); i++) {
            result += get(i) + " ";
        }
        result += "}";
        return result;
    }
 
    public void sort() {
        Collections.sort(vector);
    }
}

class SortedArray extends Array {
	public void addElement(Integer x) {
		super.addElement(x);
		sort();
	}
	
}

class MyStack {
	Array arr;
	int top;
	
	public MyStack() {
		arr = new Array();
		top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int x) {
		top = top + 1;
		arr.addElement(x, top);
	}
	
	public int pop() {
		if (isEmpty()) {
			return 100000;
		}
		top--;
		return arr.remove(top + 1);
	}
	
	public String toString() {
		String ans = "";
		ans += "[ ";
		for (int i = 0; i < arr.getSize(); i++) {
			ans += arr.get(i) + " ";
		}
		ans += "]";
		return ans;
	}
}

class Problem2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedArray arr = new SortedArray();
		arr.addElement(3);
		arr.addElement(7);
		arr.addElement(1);
		arr.addElement(14);
		arr.addElement(5);
		System.out.println(arr);
		
		MyStack s = new MyStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s);
		System.out.println(s.pop());
	}
}
