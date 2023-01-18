import java.util.*;

interface Strategy {
	public float calcul(int aniVechime, float salariu);
}

class TwentyStrategy implements Strategy {
	@Override
	public float calcul(int aniVechime, float salariu) {
		// TODO Auto-generated method stub
		return (float) (aniVechime) / 20 * salariu;
	}	
}

class ThirtyStrategy implements Strategy {

	@Override
	public float calcul(int aniVechime, float salariu) {
		// TODO Auto-generated method stub
		return (float) (aniVechime) / 30 * salariu;
	}
	
}

class FortyStrategy implements Strategy {

	@Override
	public float calcul(int aniVechime, float salariu) {
		// TODO Auto-generated method stub
		return (float) (aniVechime) / 40 * salariu;
	}
	
}

class Pensionar {
	int aniVechime;
	float salariu;
	Strategy strategy;
	
	public Pensionar(int aniVechime, float salariu) {
		this.aniVechime = aniVechime;
		this.salariu = salariu;
	}
	
	public float getPensie() {
		if (20 <= aniVechime  && aniVechime < 30) {
			strategy = new TwentyStrategy();
			return strategy.calcul(aniVechime, salariu);
		} else if (30 <= aniVechime  && aniVechime < 40) {
			strategy = new ThirtyStrategy();
			return strategy.calcul(aniVechime, salariu);
		} else if (40 <= aniVechime) {
			strategy = new FortyStrategy();
			return strategy.calcul(aniVechime, salariu);
		}
		
		return 0;
	}
}

class Main {
	public static void main(String[] args) {
		Pensionar pensionar1 = new Pensionar(25, 5000);
		Pensionar pensionar2 = new Pensionar(35, 5000);
		Pensionar pensionar3 = new Pensionar(45, 5000);
		System.out.println(pensionar1.getPensie());
		System.out.println(pensionar2.getPensie());
		System.out.println(pensionar3.getPensie());
	}
}