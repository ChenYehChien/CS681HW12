package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;

public class Customer {
	private ReentrantLock lock = new ReentrantLock();
	private Address address;
	
	public Customer(Address addr) {
		address = addr;
	}
	
	public void setAddress(Address addr) {
		lock.lock();
		try {
			address = addr;
		}
		finally {
			lock.unlock();
		}
	}
	
	public Address getAddress() {
		lock.lock();
		try {
			return address;
		}
		finally {
			lock.unlock();
		}
	}
}