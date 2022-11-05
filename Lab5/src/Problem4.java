import java.util.*;



class Warrior {
    //0 = dead, 100 = full strength
    private int health;
    private String name;
    private int damage;
    
    public Warrior(int health, String name) {
        this.health = health;
        this.name = name;
    }
    
    public int getHealth() {
    	return health;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setHealth(int h) {
    	health = h;
    }
    
    public void setName(String n) {
    	name = n;
    }
    
    public int getDamage() {
    	return damage;
    }
    
    public void setDamage(int d) {
    	damage = d;
    }
    
    public String toString() {
    	String ans = "";
    	ans += "Warrior " + name + " has " + health + " health";
    	return ans;
    }
}

class SnakeWarrior extends Warrior {
	public SnakeWarrior(int health, String name) {
		super(health, name);
	}
	
	public int getDamage() {
		int d = 10;
		super.setDamage(d);
		return super.getDamage();
	}
	
	public String toString() {
		String ans = "";
		ans = "Warrior " + getName() + " is a snake warrior and has " + getHealth();
		return ans;
	}
}

class OgreWarrior extends Warrior {
	public OgreWarrior(int health, String name) {
		super(health, name);
	}
	
	public int getDamage() {
		int d = 6;
		super.setDamage(d);
		return super.getDamage();
	}
	
	public String toString() {
		String ans = "";
		ans = "Warrior " + getName() + " is an ogre warrior and has " + getHealth();
		return ans;
	}
}

class MarshmallowWarrior extends Warrior {
	public MarshmallowWarrior(int health, String name) {
		super(health, name);
	}
	
	public int getDamage() {
		int d = 1;
		super.setDamage(d);
		return super.getDamage();
	}
	
	public String toString() {
		String ans = "";
		ans = "Warrior " + getName() + " is a marhsmallow warrior and has " + getHealth();
		return ans;
	}
}


class WarriorPack {
    private Vector<Warrior> warriors ;

    public WarriorPack () {
        warriors = new Vector<Warrior>();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    public Vector<Warrior> getWarriors() {
        return warriors ;
    }

    public int calculateDamage() {
        int damage = 0;
        for (int i = 0; i < warriors.size(); i++) {
        	damage += warriors.get(i).getDamage();
        }
        return damage;
    }
    
    public String toString() {
    	String ans = "";
    	for (int i = 0; i < warriors.size(); i++) {
    		ans += warriors.get(i) + ", ";
    	}
    	return ans;
    }
}

class Problem4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WarriorPack wp = new WarriorPack();
		wp.addWarrior(new SnakeWarrior(23, "Marcel"));
		wp.addWarrior(new OgreWarrior(99, "Miruna"));
		wp.addWarrior(new MarshmallowWarrior(56, "Marius"));
		System.out.println(wp.calculateDamage());
	}
}