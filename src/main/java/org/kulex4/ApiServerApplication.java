package org.kulex4;

import org.kulex4.data.entity.Group;
import org.kulex4.data.entity.Student;
import org.kulex4.data.repository.GroupRepository;
import org.kulex4.data.service.GroupService;
import org.kulex4.data.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ApiServerApplication {

	@Bean
	CommandLineRunner init(GroupService groupService, StudentService studentService) {
        return (env) -> {
            Group aGroup = new Group("A", "A group");
            Group bGroup = new Group("B", "B group");
            Group cGroup = new Group("C", "C group");
            Group dGroup = new Group("D", "D group");
            Group eGroup = new Group("E", "E group");
            Arrays.asList(aGroup, bGroup, cGroup, dGroup, eGroup).forEach(groupService::saveOrUpdate);

            Student first = new Student("first", "first");
            Student second = new Student("second", "second");
            Student third = new Student("third", "third");
            Student fourth = new Student("fourth", "fourth");
            Arrays.asList(first, second, third, fourth).forEach(studentService::saveOrUpdate);
        };
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiServerApplication.class, args);
	}
}
