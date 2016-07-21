package org.kulex4.data.service;

import org.kulex4.data.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by nikolai on 19.07.16.
 */
public interface StudentService {

    List<Student> getAll();

    List<Student> getAll(Sort sort);

    List<Student> getAll(Pageable pageable);

    Student getById(Long id);

    void delete(Student student);

    Student saveOrUpdate(Student student);
}
