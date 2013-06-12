package com.sirma.itt.javacourse.timer;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;

/**
 * TimeoutHashtable class. Creates hashtable. Add and remove elements from
 * hashtable. Get element from hashtable and print all not expired elements on
 * screen.
 * 
 * @version 1.1 12 Jun 2013
 * @author Stella Djulgerova
 */
public class TimeoutHashtable {

	// class private members
	private Hashtable<String, Object> elementsHashtable;
	private Hashtable<String, Object> timersHashtable;
	private int expireTime;
	private Timer timer;

	/**
	 * Constructor. Create two hashtables.
	 */
	public TimeoutHashtable(int expireTime) {
		this.expireTime = expireTime;
		elementsHashtable = new Hashtable<String, Object>(5);
		timersHashtable = new Hashtable<String, Object>(5);
	}

	/**
	 * Put element in hashtebale.
	 * 
	 * @param key - table key
	 * @param value - value
	 */
	public void put(String key, Object value) {
		if (elementsHashtable.containsKey(key)) {
			timer = (Timer) timersHashtable.get(key);
			timersHashtable.remove(key);
			timer.cancel();
		}
		elementsHashtable.put(key, value);

		timer = new Timer();
		timer.schedule(new HashtableTimer(this, key), expireTime * 1000);
		timersHashtable.put(key, timer);
	}

	/**
	 * Get element from hashtable.
	 * 
	 * @param key - element key
	 * @return element at given position or null if not exist
	 */
	public Object get(String key) {

		Object obj = null;

		if (elementsHashtable.containsKey(key)) {
			obj = elementsHashtable.get(key);

			timer = (Timer) timersHashtable.get(key);
			timersHashtable.remove(key);
			timer.cancel();

			timer = new Timer();
			timer.schedule(new HashtableTimer(this, key), expireTime * 1000);
			timersHashtable.put(key, timer);
		}
		return obj;
	}

	/**
	 * Remove element from hashtable.
	 * 
	 * @param key - element key
	 * @return removed object or null if not exist
	 */
	public Object remove(String key) {
		Object obj = null;
		if (elementsHashtable.containsKey(key)) {
			timer = (Timer) timersHashtable.get(key);
			timer.cancel();
			timersHashtable.remove(key);
			obj = elementsHashtable.remove(key);
			System.out.println("Key " + key + " expired.");
		} 
		return obj;
	}

	/**
	 * Print all table elements on screen.
	 */
	public void showElements() {

		if (!elementsHashtable.isEmpty()) {
			Set set = elementsHashtable.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		} else {
			System.out.println("The table is empty!\n");
		}
	}
}