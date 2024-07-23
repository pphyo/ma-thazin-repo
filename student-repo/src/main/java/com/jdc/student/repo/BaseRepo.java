package com.jdc.student.repo;

import java.util.List;

public interface BaseRepo<T> {
	
	// insert or update
	void save(T t);
	
	List<T> findAll();
	
	T findById(int id);
	
}
