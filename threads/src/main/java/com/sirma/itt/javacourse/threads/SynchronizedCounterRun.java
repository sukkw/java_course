package com.sirma.itt.javacourse.threads;

public class SynchronizedCounterRun {

	public static void main(String[] args) {

		SynchronizedCounter counter = new SynchronizedCounter();

		SynchronizedThread ct1 = new SynchronizedThread(10, counter, "Thread1");
		SynchronizedThread ct2 = new SynchronizedThread(10, counter, "Thread2");
	}
}