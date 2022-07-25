package com.spring.orm2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm2.dao.StudentDao;
import com.spring.orm2.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        
//        Student student=new Student(113,"Sushruth","hyderabad");
//        int r=studentDao.insert(student);
//        System.out.println("Done  "+r);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go) {
    
        System.out.println("Press 1 for add new Student");
        System.out.println("Press 2 to display all students");
        System.out.println("Press 3 to getdetails fo a student");
        System.out.println("Press 4 to delete");
        System.out.println("Press 5 to update Student");
        System.out.println("Press 6 to exit");
        try {
        	int i=Integer.parseInt(br.readLine());
        	switch(i) {
        	case 1:{
        		//add new student
        		Student student=new Student();
        		System.out.println("Enter Student Details");
        		System.out.println("Enter Student id");
        		student.setStudentId(Integer.parseInt(br.readLine()));
        		System.out.println("Enter Student name");
        		student.setStudentName(br.readLine());
        		System.out.println("Enter Student city");
        		student.setStudentCity(br.readLine());
        		studentDao.insert(student);
        		
        		break;
        	}
        	case 2:{
        		//display all students
        		List<Student>students=studentDao.getAllStudents();
        		for(Student student:students) {
        			System.out.println(student);
        		}
        		break;
        	}
        	case 3:{
        		//get single student
        		System.out.println("Enter Student Id to get Details");
        		int id=Integer.parseInt(br.readLine());
        		Student student=studentDao.getStudent(id);
        		System.out.println(student);
        		
        		break;
        	}
        	case 4:{
        		//delete student
        		System.out.println("Enter Student Id to delete");
        		int id=Integer.parseInt(br.readLine());
        		studentDao.deleteStudent(id);
        		break;
        	}
        	case 5:{
        		//update student
        		System.out.println("Enter Student Id to update Details");
        		int id=Integer.parseInt(br.readLine());
        		Student student=new Student();
        		student.setStudentId(id);
        		System.out.println("Enter Student name");
        		student.setStudentName(br.readLine());
        		System.out.println("Enter Student city");
        		student.setStudentCity(br.readLine());
        		studentDao.update(student);
        		System.out.println(student);
        		break;
        	}
        	case 6:{
        		go=false;
        		break;
        	}
        }
        }catch (Exception e) {
			// TODO: handle exception
        	System.out.println("Invalid input");
        	System.out.println(e.getMessage());
		}
        }
        
        
        
    }
}
