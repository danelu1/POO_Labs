import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

interface Persoana extends Comparable<Persoana> {
    public double calculMedieGenerala();
    public String getNume();
    public void setNume(String nume);
    public void addMedie(double medie);
}

class Student implements Persoana {
	private String name;
	private Vector<Double> grades;
	
	public Student(String name, Vector<Double> grades) {
		this.name = name;
		this.grades = grades;
	}
	
	public String toString() {
		String ans = "";
		ans += "Student " + name + " has the grades:\n";
		for (int i = 0; i < grades.size(); i++) {
			ans += grades.get(i) + " ";
		}
		ans += "\n";
		return ans;
	}

	@Override
	public int compareTo(Persoana o) {
		// TODO Auto-generated method stub
		Student s = (Student) o; 
		if (!name.equals(s.name)) {
			return 1;
		} else {
			return (int) ((int) s.calculMedieGenerala() - this.calculMedieGenerala());
		}
	}

	@Override
	public double calculMedieGenerala() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < grades.size(); i++) {
			sum += grades.get(i);
		}
		return (double) sum / grades.size();	
	}

	@Override
	public String getNume() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setNume(String nume) {
		// TODO Auto-generated method stub
		name = nume;
	}

	@Override
	public void addMedie(double medie) {
		// TODO Auto-generated method stub
		grades.add(medie);
	}
}

class Problem3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Double> grades1 = new Vector<>();
		grades1.add(10D);
		grades1.add(9D);
		grades1.add(9D);
		grades1.add(10D);
		
		Vector<Double> grades2 = new Vector<>();
		grades2.add(9D);
		grades2.add(10D);
		grades2.add(8D);
		grades2.add(4D);
		
		Vector<Double> grades3 = new Vector<>();
		grades3.add(10D);
		grades3.add(10D);
		grades3.add(10D);
		grades3.add(9D);
		
		Student s1 = new Student("Adi", grades2);
		Student s2 = new Student("Adi", grades1);
		Student s3 = new Student("Maria", grades3);
		
		Vector<Student> v = new Vector<>();
		v.add(s1);
		v.add(s2);
		v.add(s3);
		
		Collections.sort(v);
		System.out.println(v);
	}
}
