package com.sirma.itt.javacourse.threads.hash;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TimeoutHashtable {

	Hashtable table;

	public TimeoutHashtable() {
		table = new Hashtable();
		table.put("key1", "value1");
		table.put("key2", "value2");
		table.put("key3", "value3");
		//System.out.print("Constructor");
	}

	public String add(String data) {
		return null;
	}

	public Object put(String key, Object value) {
		table.put(key, value);
		return null;

	}

	public Object get(String key) {
		// table.get(key);
		return table.get(key).toString();

	}

	public Object remove(String key) {
		// table.get(key);
		return table.get(key).toString();
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
}