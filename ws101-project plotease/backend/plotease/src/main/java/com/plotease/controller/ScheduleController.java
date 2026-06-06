package com.plotease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plotease.model.Schedule;
import com.plotease.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin("*")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping("/add")
    public Schedule add(@RequestBody Schedule schedule) {
        return service.save(schedule);
    }

    @GetMapping("/{studentId}")
    public List<Schedule> get(@PathVariable String studentId) {
        return service.getByStudentId(studentId);
    }
}