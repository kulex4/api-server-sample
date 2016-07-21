package org.kulex4.rest;

import org.kulex4.data.entity.Student;
import org.kulex4.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by nikolai on 19.07.16.
 */
@RestController
@RequestMapping(path = "/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path = {"", "/"})
    public ResponseEntity<Collection<Student>> getAllStudents() {
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
