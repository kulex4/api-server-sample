package org.kulex4.rest;

import org.kulex4.data.entity.Group;
import org.kulex4.data.service.GroupService;
import org.kulex4.data.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    @RequestMapping(
            path = {"", "/"},
            method = RequestMethod.GET
    )
    public ResponseEntity<Collection<Group>> getAllGroups() {
        List<Group> groups = groupService.getAll();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @RequestMapping(
            path = {"{id}", "{id}/"},
            method = RequestMethod.GET
    )
    public ResponseEntity<Group> getOneGroup(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(groupService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(
            path = {"{id}", "{id}/"},
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Group> deleteGroup(@PathVariable("id") Long id) throws ResourceNotFoundException {
        groupService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            path = {"", "/"},
            method = {RequestMethod.POST, RequestMethod.PUT},
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Group> createOrUpdateGroup(@RequestBody Group group) {
        Group savedGroup = groupService.saveOrUpdate(group);
        return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
    }
}
