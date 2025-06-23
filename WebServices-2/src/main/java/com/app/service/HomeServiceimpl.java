package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.app.Repository.StudentRepo;
import com.app.model.Student;

import jakarta.transaction.Transactional;
@Service
public class HomeServiceimpl implements HomeServiceI
{
 @Autowired
	StudentRepo sr;
 
	@Override
	public void addStudent(Student student) {
		sr.save(student);
		
	}

	@Override
	public List<Student> getallStudent() {
	
		List<Student> list= sr.findAll();
		return list;
	}

	@Override
	public List<Student> addListOfdStudent(List<Student> list) {
		List<Student> saveAll = sr.saveAll(list);
		return saveAll;
	}

	@Override
	public Student updateStudent(Student student) {
		Student st= sr.save(student);
		return st;
	}

	@Override
	public Student updateStudetnRoll(int rn) 
	{
	  Optional<Student> op= sr.findById(rn);
	  Student student= op.get();
	  student.setLocation("indore");
	  
	  sr.save(student);
	  
	  return student;
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		sr.deleteById(rollno);
		List<Student> list=sr.findAll();
		return list;
	}

	@Override
	public List<Student> getlocaionData(String location) {
		List<Student> list=sr.findByLocation(location);
		return list;
	}

	@Override
	public List<Student> getBymarksandlocation(String location, int marks) {
		List <Student> list= sr.findByLocationAndMarks(location,marks);
		return list;
	}

	@Override
	@Modifying
	@Transactional
	public List<Student> deleteStudentByItsLocation(String location) {
		List<Student> list = sr.deleteByLocation(location);
    	List<Student> all = sr.findAll();
	
		return list;
	}

	@Override
	public String deleteAllStudent() {
		  sr.deleteAll();

		return "deleted successfully";
	}

	
}
