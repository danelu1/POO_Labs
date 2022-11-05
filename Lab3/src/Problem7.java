class Route {
	String origin;
	String destination;
	
	public Route(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	public boolean check(Route route) {
		if (route.origin.equals(route.destination)) {
			return true;
		}
		return false;
	}
}

class ClockTime {
	int hour;
	int minute;
	
	public ClockTime(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	public int compare(ClockTime time) {
		if (time.hour > hour) {
			return 1;
		} else if (time.hour == hour && time.minute > minute) {
			return 1;
		} else if (time.hour == hour && time.minute < minute) {
			return -1;
		} else if (time.hour < hour) {
			return 1;
		}
		return 0;
	}
	
	public String toString() {
		String ans = "";
		ans += hour + ":" + minute;
		return ans;
	}
}

class Schedule {
	ClockTime departure;
	ClockTime arrival;
	
	public Schedule(ClockTime departure, ClockTime arrival) {
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public int time() {
		ClockTime diff = new ClockTime(0, 0);
		if (departure.minute > arrival.minute) {
			--arrival.hour;
			arrival.minute += 60;
		}
		
		diff.minute = arrival.minute - departure.minute;
		diff.hour = arrival.hour - departure.hour;
		
		return diff.hour * 60 + diff.minute;
	}
}

class Train {
	Route r;
	Schedule s;
	boolean local;
	
	public Train(Route r, Schedule s, boolean local) {
		this.r = r;
		this.s = s;
		this.local = local;
	}
	
	public int price() {
		if (local) {
			return s.time();
		}
		return 2 * s.time();
	}
	
	public String toString() {
		String ans = "";
		ans += local + " " + r.origin + " " + "(" + s.departure.toString() + ")" + " -> " + r.destination + " " + "(" + s.arrival.toString() + ")";
		return ans;
	}
}

class Problem7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Route r = new Route("Bucuresti Nord", "Brasov");
		ClockTime departure = new ClockTime(12, 57);
		ClockTime arrival = new ClockTime(15, 28);
		Schedule s = new Schedule(departure, arrival);
		Train train = new Train(r, s, true);
		System.out.println(train);
		System.out.println(train.price());
	}
}
