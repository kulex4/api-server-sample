package org.kulex4.data.service;

import org.kulex4.data.entity.Student;
import org.kulex4.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by nikolai on 19.07.16.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Iterable<Student> getAll(Sort sort) {
        return studentRepository.findAll(sort);
    }

    @Override
    public Iterable<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }
}
