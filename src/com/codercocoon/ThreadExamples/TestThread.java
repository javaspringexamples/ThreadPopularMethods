package com.codercocoon.ThreadExamples;

/**
 * This class presents some popular methods about threads, especially : getId,
 * getName, isAlive, sleep, interrupt.
 * 
 * @author contact@codercocoon.com
 *
 */
public class TestThread {

	public static void main(String[] args) throws InterruptedException {

		// Thread by extending the Thread class.
		ThreadByExtension t1 = new ThreadByExtension("t1");
		t1.start();
		System.out.println("t1 isAlive=" + t1.isAlive());

		// Thread by implementing the Runnable interface.
		Thread t2 = new Thread(new ThreadByImplementation(), "t2");
		t2.start();
		// Interrupting t2
		t2.interrupt();

		// Thread by implementing the Runnable interface anonymously.
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running Anonymous object runnable.");
			}
		};
		Thread t3 = new Thread(r1);
		t3.start();

		// Thread by implementing the Runnable interface anonymously using
		// lambda expression.
		Runnable r2 = () -> System.out.println("Running runnable object using lambda expression Runnable.");
		Thread t4 = new Thread(r2);
		t4.start();

		// Waiting for the t1 to be terminated.
		t1.join();

		// t1.is Alive will be always false, because t1 is terminated.
		System.out.println(t1.getId() + " " + t1.getName() + " " + t1.getPriority() + " isAlive=" + t1.isAlive());
		System.out.println(t2.getId() + " " + t2.getName() + " " + t2.getPriority());
		// The threads names are generated by the JVM, they begin by "Thread-"
		System.out.println(t3.getId() + " " + t3.getName() + " " + t3.getPriority());
		System.out.println(t4.getId() + " " + t4.getName() + " " + t4.getPriority());

	}
}
