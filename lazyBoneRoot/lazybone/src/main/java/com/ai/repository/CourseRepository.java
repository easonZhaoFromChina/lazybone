package com.ai.repository;

import com.ai.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by eason on 2017/2/15.
 */
public interface CourseRepository extends JpaRepository<Course,String> {
}
