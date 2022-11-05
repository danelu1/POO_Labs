class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;
 
    public Patrulater() {
        this(0, 0, 0, 0);
    }
 
    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }
 
    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }
 
    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }
 
    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
	public Paralelogram(int latura1, int latura2, double unghi) {
		super(latura1, latura2, latura1, latura2, unghi, Math.PI - unghi * Math.PI / 180, unghi, Math.PI - unghi * Math.PI / 180);
	}
	
	public Paralelogram(int latura1, int latura2) {
		super(latura1, latura2, latura1, latura2);
	}
	
	public double areaParalelogram() {
		return latura1 * latura2 * Math.sin(unghi1 * Math.PI / 180);
	}
}

class Dreptunghi extends Paralelogram {
	public Dreptunghi(int latura1, int latura2) {
		super(latura1, latura2, Math.PI / 2);
	}
	
	public double arieDreptunghi() {
		return latura1 * latura2;
	}
}

class Romb extends Paralelogram {
	int d1;
	int d2;
	
	public Romb(int latura, int d1, int d2) {
		super(latura, latura);
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public double arieRomb() {
		return d1 * d2 / 2;
	}
}

class Patrat extends Dreptunghi {
	public Patrat(int latura) {
		super(latura, latura);
	}
	
	public double ariePatrat() {
		return latura1 * latura2;
	}
}

class Problem1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paralelogram p = new Paralelogram(3, 4, 30);
		System.out.println(p.areaParalelogram());
		Dreptunghi d = new Dreptunghi(4, 5);
		System.out.println(d.arieDreptunghi());
		Romb r = new Romb(5, 1, 2);
		System.out.println(r.arieRomb());
		Patrat ptr = new Patrat(7);
		System.out.println(ptr.ariePatrat());
	}
}
