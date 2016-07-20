package org.kulex4.rest;

import org.kulex4.data.entity.dto.GroupResource;
import org.kulex4.data.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nikolai on 19.07.16.
 */
@RestController
@RequestMapping(path = "/groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(path = {"", "/"})
    public Resources<GroupResource> getAllGroups() {
        List<GroupResource> groupResourceList = new ArrayList<>();
        groupService.getAll().forEach(
                group -> groupResourceList.add(new GroupResource(group))
        );
        return new Resources<>(groupResourceList);
    }
}
