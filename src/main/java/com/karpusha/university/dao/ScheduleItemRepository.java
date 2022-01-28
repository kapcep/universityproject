package com.karpusha.university.dao;

import com.karpusha.university.entity.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleItemRepository extends JpaRepository<ScheduleItem, Integer> {
}
