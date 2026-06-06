package com.plotease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plotease.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByStudentId(String studentId);
}