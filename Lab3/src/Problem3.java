class MyArray {
    private int v[];
    private int size;
 
    public MyArray() {
        this(100);
    }
 
    public MyArray(int length) {
        size = 0;
        v = new int[length];
    }
 
    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }
 
    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }
 
    public int getSize() {
        return size;
    }
}

class MyQueue {
	private MyArray arr;
	private final int Infinit = 9500;
	private int first;
	private int last;
	private int size;
	
	public MyQueue() {
		arr = new MyArray(size);
		first = -1;
		last = -1;
		size = 6;
	}
	
	public int getSize() {
		return size;
	}
	
	public void enqueue(int value) {
		arr.get(last) = value;
		last += 1;
		first += 1;
		
	}
	
	public boolean isEmpty() {
		return false;
	}
}
 
 
class Test {
    public static void main(String args[]) {
//        MyQueue queue = new MyQueue();
//        queue.enqueue(7);
//        queue.enqueue(8);
//        queue.enqueue(10);
//        queue.enqueue(-1);
//        queue.enqueue(2);
//        System.out.println(queue);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.getSize());
//        System.out.println(queue);
//        queue.enqueue(9);
//        queue.enqueue(queue.dequeue());
//        queue.enqueue(11);
//        queue.enqueue(22);
//        System.out.println(queue);
//        while(!queue.isEmpty()) {
//            System.out.print(queue.dequeue() + " ");
//        }
//        System.out.println("");
//        System.out.println(queue);
    }
}
