package com.sirma.itt.javacourse.threads.hash;

public class Timeout implements Runnable {

	private Thread thread;
	private TimeoutHashtable table;

	public Timeout(Object table, String name) {
		thread = new Thread(this, name);
		table = table;
	}

	@Override
	public void run() {
		while (!table.isUsed()) {
			try {
				wait(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!table.isUsed()) {
				break;
			} else {
				table.setUsed(false);
			}
		}
		
		table.remove(thread.getName());

		return;	
	}

}
