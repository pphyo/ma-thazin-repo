package com.jdc.student.repo;

public interface CrudRepo<T> extends BaseRepo<T> {

	void delete(int id);
	
}
