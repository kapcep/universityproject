package com.karpusha.university.dao;

import com.karpusha.university.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGroupRepository extends JpaRepository<StudentGroup,Integer> {
}
