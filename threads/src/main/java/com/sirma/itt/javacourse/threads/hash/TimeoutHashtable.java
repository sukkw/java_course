package com.sirma.itt.javacourse.threads.hash;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
* TimeoutHashtable class. Creates hashtable.
* Add and remove elements from hashtable. Get element from hashtable and print 
* all not expired elemnts on screen.
*
* @version 1.1 09 Jun 2013
* @author Stella Djulgerova
*/
public class TimeoutHashtable {

	// class private members
	private Hashtable<String, Object> table;
	private Hashtable<String, Object> timeout;
	private int expiredTime = 10000;
	private boolean used;

	/**
	 * Constructor. Create two hashtables.
	 */
	public TimeoutHashtable() {
		table = new Hashtable<String, Object>(5);
		timeout = new Hashtable<String, Object>(5);
	}
	
	/**
	 * Put element in hashtebale.
	 * @param key - table key
	 * @param value - value
	 */
	public void put(String key, Object value) { 
		if(table.containsKey(key)) {
			table.put(key, value);
			used = true;
			Timeout timer = (Timeout) timeout.get(key);
			timer.notifyThread();	
		} else {
			table.put(key, value);
			Timeout timer = new Timeout(this, expiredTime);
			timer.setName(key);
			timer.start();
			timeout.put(key,timer);
			used = false;
		}
	}

	/**
	 * Get element from hashtable.
	 * @param key - element key
	 * @return element at given position or null if not exist
	 */
	public Object get(String key) {
		
		Object obj;							
					
			if(table.containsKey(key)){	
				obj = table.get(key);
				used = true;
				Timeout timer = (Timeout) timeout.get(key);
				timer.notifyThread();					
			} else {							
				obj = null;						
			}			

		return obj;
	}

	/**
	 * Remove element from hashtable.
	 * @param key - element key
	 * @return removed object or null if not exist
	 */
	public Object remove(String key) {
		Object obj;
		if(table.containsKey(key)) {
			obj = table.remove(key);
			timeout.remove(key);
			System.out.println("Key " + key + " expired.");	
		} else {
			obj = null;
		}
	
		return obj;
	}

	/**
	 * Print all table elements on screen.
	 */
	public void showElements() {

		if (!table.isEmpty()) {
			Set set = table.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		} else {
			System.out.println("The table is empty!\n");
		}
	}

	/**
	 * Check if element is recent in use.
	 * @return true if element has been used in last 10 seconds. False if not
	 */
	public boolean isUsed() {
		return used;
	}
	
	/**
	 * Set element used value.
	 * @param used
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}
}