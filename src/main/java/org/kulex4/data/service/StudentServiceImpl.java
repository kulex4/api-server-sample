package org.kulex4.data.service;

import org.kulex4.data.entity.Student;
import org.kulex4.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public List<Student> getAll() {
        Iterable<Student> groups = studentRepository.findAll();
        return StreamSupport.stream(groups.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getAll(Sort sort) {
        Iterable<Student> groups = studentRepository.findAll(sort);
        return StreamSupport.stream(groups.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getAll(Pageable pageable) {
        Iterable<Student> groups = studentRepository.findAll(pageable);
        return StreamSupport.stream(groups.spliterator(), false)
                .collect(Collectors.toList());
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
