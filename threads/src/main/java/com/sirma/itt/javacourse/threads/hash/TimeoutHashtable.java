package com.sirma.itt.javacourse.threads.hash;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TimeoutHashtable {

	Hashtable<String, Object> table;
	Hashtable<String, Object> timeout;
	private int time;
	private boolean used;

	public TimeoutHashtable() {
		table = new Hashtable<String, Object>();
		timeout = new Hashtable<String, Object>();
/*		table.put("key1", "value1");
		table.put("key2", "value2");
		table.put("key3", "value3");
		System.out.print("Constructor");*/
	}
	
	public synchronized Object put(String key, Object value) {
		if(table.containsKey(key)) {
			table.put(key, value);
			used = true;
			Timeout timer = (Timeout) timeout.get(key);
			timer.notify();	
		} else {
			table.put(key, value);
			Timeout timer = new Timeout(this, key);
			timeout.put(key,timer);
			used = false;
		}
		
		return null;
	}

	public Object get(String key) {
		
		Object obj;							
					
			if(table.containsKey(key)){	
				obj = table.get(key);
				used = true;
				Timeout timer = (Timeout) timeout.get(key);
				timer.notify();						
			} else {							
				obj = null;						
			}			

		return obj;
	}

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

	public String showElements() {

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
		return null;
	}

	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
}