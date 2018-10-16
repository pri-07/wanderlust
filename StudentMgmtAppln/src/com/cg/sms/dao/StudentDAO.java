package com.cg.sms.dao;

import java.util.ArrayList;

import com.cg.sms.dto.Student;


public interface StudentDAO {
	
	public int addStudent(Student student);
	public Student getStudent(int rn);
	public Student updateStudent(Student student);
	public ArrayList<Student> getStudentList(String coursename);

}
