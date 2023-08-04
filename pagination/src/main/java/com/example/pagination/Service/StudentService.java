package com.example.ProjectK1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ProjectK1.Model.Student;
import com.example.ProjectK1.Repository.StudentRepo;

@Service
public class StudentService {
@Autowired
private StudentRepo studentRepo;
    public List<Student> get() {
        List<Student> list = studentRepo.findAll();
        return  list;
    }
    public void save(Student student) {
        Student student2 = new Student();
        student2.setEmail(student.getEmail());
        student2.setName(student.getName());
        studentRepo.save(student2);
    }
    public void update(Long id,Student student) {
        Student student1 = studentRepo.getReferenceById(id);
        student1.setEmail(student.getEmail());
        student1.setName(student.getName());
        studentRepo.save(student1);

    }
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }
    public Optional<Student> getById(Long id) {
        Optional<Student> list = studentRepo.findById(id);
        return list;
    }
    public Page<Student> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size,Sort.by("id").ascending());
        return studentRepo.findAll(pageable);
    }


    
}
