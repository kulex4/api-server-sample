package org.kulex4.repository;

import org.kulex4.data.Group;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by nikolai on 14.07.16.
 */
@RepositoryRestResource(path = "/groups")
public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
}
