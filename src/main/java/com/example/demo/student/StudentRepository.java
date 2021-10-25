package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT COUNT(s.id) FROM Student s WHERE s.email = :email")
    Long countStudentsWithEmail(String email);

}
