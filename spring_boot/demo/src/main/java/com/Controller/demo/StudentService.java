package com.Controller.demo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    public StudentService() {
        students.add(new Student(1, "A"));
        students.add(new Student(2, "XYZ"));
        students.add(new Student(3, "Diksha"));
    }
    public boolean deleteStudentById(int id) {
        return students.removeIf(student -> student.getId() == id);
    }
}

