import java.util.Vector;

class Person {
	String name;
	String address;
	
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String a) {
		address = a;
	}
	
	public String toString() {
		String ans = "";
		ans += "Person " + name + " lives in " + address;
		return ans;
	}
}

class Student extends Person {
	Vector<String> courses;
	Vector<Integer> grades;
	
	public Student(String name, String address) {
		super(name, address);
		courses = new Vector<>();
		grades  = new Vector<>();
	}
	
	public void addCourseGrade(String course, int grade) {
		courses.add(course);
		grades.add(grade);
	}
	
	public void printGrades() {
		for (int i = 0; i < grades.size(); i++) {
			System.out.print(grades.get(i) + " ");
		}
	}
	
	public double getAverageGrade() {
		int sum = 0;
		for (int i = 0; i < grades.size(); i++) {
			sum += grades.get(i);
		}
		return (double) sum / grades.size();
	}
	
	public String toString() {
		String ans = "";
		ans += "Student " + name + " lives in " + address + " and has the courses and grades :\n";
		for (int i = 0; i < grades.size(); i++) {
			ans += courses.get(i) + " : " + grades.get(i);
			ans += "\n";
		}
		return ans;
	}
}

class Teacher extends Person {
	
}

class Problem4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("Popescu Mihai", "Brasov");
		s.addCourseGrade("Programare", 10);
		s.addCourseGrade("Algebra", 7);
		System.out.println(s);
		System.out.println(s.getAverageGrade());
	}
}
