package org.kulex4.rest;

import org.kulex4.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
