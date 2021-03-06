package org.espire.deadlock;

/*
 * Avoiding deadlock in Java
 */
class SynchThread implements Runnable {

	private Object object1;
	private Object object2;

	public SynchThread(Object o1, Object o2) {
		this.object1 = o1;
		this.object2 = o2;
	}

	// overriding run() method of the Thread class
	// it allows two threads are running concurrently
	@Override
	public void run() {
		// getting the current thread name
		String thredName = Thread.currentThread().getName();
		System.out.println(thredName + " acquire lock on " + object1);
		// Synchronized() method is used to lock an object for any shared resource. When
		// a thread invokes the synchronized() method,
		// it automatically acquires the lock for that object and releases it when the
		// thread completes its task.
		synchronized (object1) {
			System.out.println(thredName + " acquired lock on " + object1);
			// calling work() method
			work();
		}
		System.out.println(thredName + " released lock of " + object1);
		System.out.println(thredName + " acquire lock on " + object2);

		synchronized (object2) {
			System.out.println(thredName + " acquire lock on " + object2);
			work();
		}
		System.out.println(thredName + " released lock of " + object2);
		System.out.println(thredName + " execution is completed.");
	}

	public void work() {
		try {
			// the sleep() method suspends the execution of the current thread for 5 seconds
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void deadlock() throws InterruptedException {
		// Creating object of the Object class
		Object object1 = new Object();
		Object object2 = new Object();
		Object object3 = new Object();

		// Creating constructor of the Thread Class and passing SynchroniseThread object
		// as a parameter
		Thread thread1 = new Thread(new SynchThread(object1, object2), "Thread1");
		Thread thread2 = new Thread(new SynchThread(object2, object3), "Thread2");
		// executing thread1
		thread1.start();
		// the sleep() method suspends the execution of the current thread (thread1) for
		// the specific period
		Thread.sleep(2000);
		// executing thread2
		thread2.start();
		// suspends the execution of the current thread (thread2) for the specific
		// period
		Thread.sleep(2000);
	}
}

public class DeadLock {

	public static void main(String args[]) throws InterruptedException {

		SynchThread.deadlock();

	}
}
