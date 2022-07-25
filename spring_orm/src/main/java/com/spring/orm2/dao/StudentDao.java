package com.spring.orm2.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm2.entities.Student;

@Transactional
public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public int insert(Student student) {
		Integer rowsAffected=(Integer)this.hibernateTemplate.save(student);
		return rowsAffected;
	}
	
	//get the single data
	public Student getStudent(int studentId) {
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	//get all students
	public List<Student> getAllStudents(){
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
	//delete
	@Transactional
	public void deleteStudent(int studentId) {
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	//update data
	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
