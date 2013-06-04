package com.sirma.itt.javacourse.threads;

public class SynchronizedThread implements Runnable {

	private SynchronizedCounter counter;
	private int maxCounterValue;
	private String name;
	private Thread thread;
	private int count;
	private String runnigThreadName = "Thread1";

	public SynchronizedThread(int maxCounterValue, SynchronizedCounter counter,
			String name) {
		
		this.counter = counter;
		this.maxCounterValue = maxCounterValue;
		this.name = name;
		thread = new Thread(this, name);
		thread.start();
	}

	public void run() {
		while(count < maxCounterValue) {
			//System.out.println(thread.getName() + " > "+counter);
			//counter.printCounter(count, thread.getName());
			
			if(!runnigThreadName.equals(thread.getName())){
				try {
					wait();
				} catch (InterruptedException e) {}
			}
			System.out.println(thread.getName() + " > "+counter);
			if(runnigThreadName.equals("Thread1"))
				runnigThreadName = "Thread2";
			else
				runnigThreadName = "Thread1";
			notifyAll();
			
			count++;
		}
	}

}
