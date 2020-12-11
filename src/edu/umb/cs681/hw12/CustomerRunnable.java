package edu.umb.cs681.hw12;

public class CustomerRunnable extends Customer implements Runnable {
	
	public CustomerRunnable(Address addr) {
		super(addr);
	}

	public void run() {
		Address addr = new Address("last", "Boston", "MA", 54321);
			
		System.out.println("Origin: " + this.getAddress().toString());
		this.setAddress(addr);
		System.out.println("Changed: " + this.getAddress().toString());
	}
	
	public static void main(String[] args) throws InterruptedException {
		//String street, String city, String state, int zipcode
		Address addr1 = new Address("1st", "Boston", "MA", 12345);
		Address addr2 = new Address("2nd", "Boston", "MA", 12345);
		Address addr3 = new Address("3rd", "Boston", "MA", 12345);
		
		Thread t1 = new Thread(new CustomerRunnable(addr1));
		Thread t2 = new Thread(new CustomerRunnable(addr2));
		Thread t3 = new Thread(new CustomerRunnable(addr3));
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
	}
	
}