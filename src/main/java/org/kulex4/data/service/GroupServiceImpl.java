package org.kulex4.data.service;

import org.kulex4.data.entity.Group;
import org.kulex4.data.repository.GroupRepository;
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
@Service("groupService")
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAll() {
        Iterable<Group> groups = groupRepository.findAll();
        return StreamSupport.stream(groups.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Group> getAll(Sort sort) {
        Iterable<Group> groups = groupRepository.findAll(sort);
        return StreamSupport.stream(groups.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Group> getAll(Pageable pageable) {
        Iterable<Group> groups = groupRepository.findAll(pageable);
        return StreamSupport.stream(groups.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Group getById(Long id) {
        return groupRepository.findOne(id);
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public Group saveOrUpdate(Group group) {
        return groupRepository.save(group);
    }
}
