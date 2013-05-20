package com.sirma.itt.javacourse.pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Create object pool. Only fixed number of instances of class 
 * are allowed in pool. Instance can be used via acquire method 
 * and released after work is done.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Pool {

	// class private members
	private List<DataClass> instancesList;
	private int maxInstancesInPool;

	/**
	 * Constructor.
	 * @param maxInstancesInPool - max count instances allowed to be stored in pool
	 */
	public Pool(int maxInstancesInPool) {
		this.maxInstancesInPool = maxInstancesInPool;
		createPool();
	}

	/**
	 * Fill the pool.
	 */
	private void createPool() {
		DataClass data;
		instancesList = new ArrayList(maxInstancesInPool);
		for (int i = 0; i < maxInstancesInPool; i++) {
			data = new DataClass();
			instancesList.add(data);
		}
	}

	/**
	 * Get instance from pool.
	 * @return object to be used
	 * @throws PoolException
	 */
	public Object acquire() throws PoolException {
		Object object;
		if (instancesList.isEmpty()) {
			throw new PoolException("Pool is empty");
		} else {
			System.out.println("Object " + instancesList.size() + " acquired...");
			object = (Object) instancesList.remove(instancesList.size() - 1);
		}
		return object;
	}

	/**
	 * Return resource in pool
	 * @param data - released resource
	 * @throws PoolException
	 */
	public void release(DataClass data) throws PoolException {
		if (instancesList.size() == maxInstancesInPool) {
			throw new PoolException("Pool is full");
		} else {
			instancesList.add(data);
			System.out.println("Object " + instancesList.size() + " released...");
		}
	}
}
