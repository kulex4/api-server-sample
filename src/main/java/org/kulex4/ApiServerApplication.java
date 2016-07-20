package org.kulex4;

import org.kulex4.data.entity.Group;
import org.kulex4.data.repository.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ApiServerApplication {

	@Bean
	CommandLineRunner init(GroupRepository groupRepository) {
        Group aGroup = new Group("A", "A group");
        Group bGroup = new Group("B", "B group");
        Group cGroup = new Group("C", "C group");
        Group dGroup = new Group("D", "D group");
        Group eGroup = new Group("E", "E group");
        return (env) -> groupRepository.save(
                Arrays.asList(aGroup, bGroup, cGroup, dGroup, eGroup)
        );
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiServerApplication.class, args);
	}
}
