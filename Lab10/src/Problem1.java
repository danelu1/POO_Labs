class Binding {
    public static void main(String args[]) {
        Hero h1 = new Warrior(), h2 = new Ninja();
        Hero h3 = new Rogue();
        BadLuck bl = new StormFire();
        bl.execute(h1);
        bl.execute(h2);
        bl.execute(h3);
    }
}
 
abstract class BadLuck {
    abstract void execute(Hero h);
    abstract void execute(Warrior w);
    abstract void execute(Ninja n);
    abstract void execute(Rogue r);
}

class StormFire extends BadLuck {
	@Override
	void execute(Hero h) {
		// TODO Auto-generated method stub
		h.execute();
	}

	@Override
	void execute(Warrior w) {
		// TODO Auto-generated method stub
		w.execute();
	}

	@Override
	void execute(Ninja n) {
		// TODO Auto-generated method stub
		n.execute();
	}

	@Override
	void execute(Rogue r) {
		// TODO Auto-generated method stub
		r.execute();
	}
}

abstract class Hero {
	abstract void execute();
}

class Warrior extends Hero {
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute Warrior");
	}
}

class Ninja extends Hero {
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute Ninja");
	}
}

class Rogue extends Hero {
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute Rogue");
	}
}