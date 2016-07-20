package org.kulex4.data.repository;

import org.kulex4.data.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nikolai on 14.07.16.
 */
@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}
