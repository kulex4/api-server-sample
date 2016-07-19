package org.kulex4.data.service;

import org.kulex4.data.entity.Group;
import org.kulex4.data.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public Iterable<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Iterable<Group> getAll(Sort sort) {
        return groupRepository.findAll(sort);
    }

    @Override
    public Iterable<Group> getAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
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
