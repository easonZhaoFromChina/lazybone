package com.ai.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.domain.CourseUserRank;


public interface CourseUserRankRepository extends JpaRepository<CourseUserRank, String> {

	@Transactional
	void deleteByRankDate(Date date);

	Page<CourseUserRank> findByCourseIdAndRankDateBetweenOrderByRank(String courseId, Date startDate, Date endDate,
			Pageable pageable);
}
