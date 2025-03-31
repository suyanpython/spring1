package com.luv2code.springboot.demo.mycoolapp.dao;

import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    void save(Student student);

    @Query("SELECT s FROM Student s WHERE s.id = :id")
    Student findId(
            @Param("id") Integer id
    );

    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    void update(Student student);
    void delete(Integer id);

    int deleteAll();
}
