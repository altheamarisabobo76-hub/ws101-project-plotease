package com.plotease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plotease.model.Schedule;
import com.plotease.repository.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repo;

    public Schedule save(Schedule schedule) {
        return repo.save(schedule);
    }

    public List<Schedule> getByStudentId(String studentId) {
        return repo.findByStudentId(studentId);
    }
}