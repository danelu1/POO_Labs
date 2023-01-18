import java.util.*;

class ShopSingleton {
	private static ShopSingleton single_instance = null;
	String name;
	List<Product> products;
	
	private ShopSingleton() {
		products = new ArrayList<>();
	}
	
	public static ShopSingleton getInstance() {
		if (single_instance == null) {
			single_instance = new ShopSingleton();
		}
		return single_instance;
	}
	
	public void showProducts() {
		for (Product p : products) {
			System.out.println(p);
		}
	}
}

abstract class Product {
	float price;
	String name;
	
	public Product(float price, String name) {
		this.price = price;
		this.name = name;
	}
	
	public String toString() {
		return "Produs " + name + " " + price;
	}
	
	abstract public float getPricedReduced();
}

class Book extends Product {
	public Book(float price, String name) {
		super(price, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getPricedReduced() {
		// TODO Auto-generated method stub
		return this.price - 0.15F * this.price;
	}
}

class Food extends Product {

	public Food(float price, String name) {
		super(price, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getPricedReduced() {
		// TODO Auto-generated method stub
		return this.price - 0.2F * this.price;
	}
	
}

class Beverage extends Product {

	public Beverage(float price, String name) {
		super(price, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getPricedReduced() {
		// TODO Auto-generated method stub
		return this.price - 0.05F * this.price;
	}
	
}

class Computer extends Product {

	public Computer(float price, String name) {
		super(price, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getPricedReduced() {
		// TODO Auto-generated method stub
		return this.price - 0.1F * this.price;
	}
	
}

class ProductFactory {
	public Product factory(String type, String nameProduct, float productPrice) {
		if (type.equals("Book")) {
			return new Book(productPrice, nameProduct);
		} else if (type.equals("Food")) {
			return new Food(productPrice, nameProduct);
		} else if (type.equals("Beverage")) {
			return new Beverage(productPrice, nameProduct);
		} else if (type.equals("Computer")) {
			return new Computer(productPrice, nameProduct);
		} else {
			return null;
		}
	}
}

class Test {
	public void addProduct(Product p) {
		ShopSingleton shop = ShopSingleton.getInstance();
		
		shop.products.add(p);
	}
	
	public void removeProduct(Product p) {
		ShopSingleton shop = ShopSingleton.getInstance();
		
		shop.products.remove(shop.products.indexOf(p));
	}
	
	public Product getCheapestProduct() {
		ShopSingleton shop = ShopSingleton.getInstance();
		
		Product product = shop.products.get(0);
		
		for (Product p : shop.products) {
			if (product.price > p.price) {
				product = p;
			}
		}
		
		return product;
	}
	
	public static void main(String[] args) {
		ShopSingleton shop = ShopSingleton.getInstance();
		
		Test test = new Test();
		
		ProductFactory product = new ProductFactory();
		
		Product p1 = product.factory("Book", "Gigel Frone", 50);
		Product p2 = product.factory("Food", "Paine", 10);
		Product p3 = product.factory("Beverage", "Absolute", 55);
		Product p4 = product.factory("Computer", "Lenovo Ideapad Gaming 3", 4000);
		
		test.addProduct(p1);
		test.addProduct(p2);
		test.addProduct(p3);
		test.addProduct(p4);
		
		shop.showProducts();
		
		System.out.println();
		
		System.out.println(p1.getPricedReduced());
		System.out.println(p2.getPricedReduced());
		System.out.println(p3.getPricedReduced());
		System.out.println(p4.getPricedReduced());
	}
}