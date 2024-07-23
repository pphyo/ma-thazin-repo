package com.jdc.student.mem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jdc.student.domain.Student;

public class StudentRepoMemImpl extends AbstractStudentRepo {
	
	private List<Student> list;

	StudentRepoMemImpl() {
		list = new ArrayList<>();
	}

	@Override
	public void delete(int id) {
	}

	@Override
	public void save(Student t) {
	}

	@Override
	public List<Student> findAll() {
		return Collections.unmodifiableList(list);
	}

	@Override
	public Student findById(int id) {
		var index = findIndex(id);
		return list.get(id);
	}

	private Student findIndex(int id) {
		
		return null;
	}
	
}
