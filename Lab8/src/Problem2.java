import java.util.*;

class Catalog extends TreeSet<Catalog.Student> {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Catalog(Comparator<Catalog.Student> cmp) {
		super(cmp);
	}
	
	public Catalog() {
		this(null);
	}
	
	public void addStudent(String name, double media, int clazz) {
		add(new Catalog.Student(name, media, clazz));
	}
	
	public Student getStudent(String name) {
		Iterator<Catalog.Student> it = iterator();
		Catalog.Student s = null;
		while (it.hasNext()) {
			s = it.next();
			if (s.name.equals(name)) {
				break;
			}
		}
		return s;
	}
	
	public void removeStudent(String name) {
		Iterator<Catalog.Student> it = iterator();
		Catalog.Student s = null;
		while (it.hasNext()) {
			s = it.next();
			if (s.name.equals(name)) {
				remove(s);
				break;
			}
		}
	}
	
	public Catalog byClass(int clazz) {
		Catalog catalog = new Catalog();
		Iterator<Catalog.Student> it = iterator();
		while (it.hasNext()) {
			Catalog.Student s = it.next();
			if (s.clazz == clazz) {
				catalog.add(s);
			}
		}
		return catalog;
	}
	
	class Student implements Comparable<Student> {
		String name;
		double media;
		int clazz;
		
		public Student(String name, double media, int clazz) {
			this.name = name;
			this.media = media;
			this.clazz = clazz;
		}
		
		public String toString() {
			String ans = "";
			ans += "Studentul " + name + " are media " + media + " si este la grupa " + clazz;
			return ans;
		}
		
		@Override
		public int compareTo(Catalog.Student o) {
			// TODO Auto-generated method stub
			if (o.media < media) {
				return 1;
			} else if (o.media == media){
				return (name.compareTo(o.name));
			} else {
				return -1;
			}
		}
	}
}

class Task2 {

    public static void main(String args[]) {
        Catalog catalog = new Catalog();
        catalog.addStudent("Alexandru", 7, 324);
        catalog.addStudent("Ioana", 5, 321);
        catalog.addStudent("Maria", 10, 322);
        catalog.addStudent("Ionut", 6.2, 323);
        catalog.addStudent("Diana", 7, 322);
        System.out.println(catalog.size());

        Catalog catalog2 = new Catalog(new Comparator<Catalog.Student>() {
            @Override
            public int compare(Catalog.Student o1, Catalog.Student o2) {
                // TODO: Sort by average (descending) and by name (ascending).
               return o1.compareTo(o2);
            }
        });
        catalog2.addAll(catalog);

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + catalog);
        System.out.println("Continutul colectiei: " + catalog2);

        Catalog.Student last = null;
        for (Catalog.Student o : catalog) {
            if (last == null) {
                last = o;
                continue;
            }
            int r = last.media != o.media ? new Double(last.media).compareTo(o.media) : last.name.compareTo(o.name);
            if (r != last.compareTo(o)) {
                System.err.println("Catalog.Student.compareTo a fost implementata gresit.");
            }
        }

        if (catalog.size() != 5) {
            System.err.println("Catalog.size() a fost implementata gresit.");
        }

        catalog.removeStudent("Ionut");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }
        catalog.removeStudent("");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.byClass(322).size() != 2) {
            System.err.println("Catalog.byClass() a fost implementata gresit.");
        }

        catalog.removeStudent("Maria");
        if (catalog.byClass(322).size() != 1) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.getStudent("Maria") != null) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }

        if ((catalog.getStudent("Alexandru") == null) || (catalog.getStudent("Alexandru").media != 7)) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }
    }

}
