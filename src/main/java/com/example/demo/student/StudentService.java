package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        // need to implement validation
        Boolean emailExists = studentRepository.countStudentsWithEmail(student.getEmail()) > 0 ? true : false;

        if (emailExists) throw new BadRequestException("Email: " + student.getEmail() + " is taken");

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException("There is no student with id " + studentId.toString());
        }
        studentRepository.deleteById(studentId);
    }
}
