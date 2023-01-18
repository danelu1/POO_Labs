import java.util.*;

class Channel {
	List<User> users;
	public String channelName;
	
	public Channel(String name) {
		users = new ArrayList<>();
		this.channelName = name;
	}
	
	public void subscribe(User user) {
		users.add(user);
	}
	
	public void unsubscribe(User user) {
		users.remove(users.indexOf(user));
	}
	
	public void notify(String notification) {
		for (User user : users) {
			user.update(notification);
		}
	}
}

class User {
	public String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public void update(String notification) {
		System.out.println(name + " " + notification);
	}
	
	public String toString() {
		return name;
	}
}

class Main {
	public static void main(String[] args) {
		Channel channel = new Channel("Codrin Bradea Satana");
		
		channel.subscribe(new User("Mircea"));
		channel.subscribe(new User("Marian"));
		channel.subscribe(new User("Mihaela"));
		channel.subscribe(new User("Andrei"));
		channel.subscribe(new User("Adelina"));
		channel.subscribe(new User("Alexandra"));
		
		System.out.println(channel.users);
		
		channel.notify("a aparut un video nou");
		
		channel.unsubscribe(channel.users.get(0));
		
		System.out.println();
		
		channel.notify("a aparut un video nou");
	}
}