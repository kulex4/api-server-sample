package org.kulex4.data.service;

import org.kulex4.data.entity.Group;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by nikolai on 19.07.16.
 */
public interface GroupService {

    Iterable<Group> getAll();

    Iterable<Group> getAll(Sort sort);

    Iterable<Group> getAll(Pageable pageable);

    Group getById(Long id);

    void delete(Group group);

    Group saveOrUpdate(Group group);

}
