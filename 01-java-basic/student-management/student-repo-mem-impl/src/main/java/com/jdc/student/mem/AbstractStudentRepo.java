package com.jdc.student.mem;

import com.jdc.student.domain.Student;
import com.jdc.student.repo.CrudRepo;

public abstract class AbstractStudentRepo implements CrudRepo<Student> {

	private static AbstractStudentRepo INSTANCE;
	
	public static AbstractStudentRepo getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new StudentRepoMemImpl();
		}
		return INSTANCE;
	}
	
}
