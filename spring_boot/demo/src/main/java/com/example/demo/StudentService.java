package com.example.demo;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class StudentService {
    private final Map<Integer, Student> students = new ConcurrentHashMap<>();

    public Student registerStudent(Student student) {
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student with ID " + student.getId() + " already exists");
        }
        students.put(student.getId(), student);
        return student;
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public boolean deleteStudent(int id) {
        return students.remove(id) != null;
    }
}