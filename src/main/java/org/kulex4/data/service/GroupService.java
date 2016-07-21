package org.kulex4.data.service;

import org.kulex4.data.entity.Group;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by nikolai on 19.07.16.
 */
public interface GroupService {

    List<Group> getAll();

    List<Group> getAll(Sort sort);

    List<Group> getAll(Pageable pageable);

    Group getById(Long id);

    void delete(Group group);

    Group saveOrUpdate(Group group);

}
