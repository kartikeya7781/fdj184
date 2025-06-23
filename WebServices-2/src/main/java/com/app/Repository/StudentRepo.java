package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{

  public List<Student> findByLocation(String location);

  public List<Student> findByLocationOrMarks(String location, int marks);

  public List<Student> deleteByLocation(String location);

public List<Student> findByLocationAndMarks(String location, int marks);


}
