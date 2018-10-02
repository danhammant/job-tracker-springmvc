package com.danhammant.jobtracker.spring;

import com.danhammant.jobtracker.model.Job;

import java.util.List;

public interface JobService {
    void addJob(Job job);
    void updateJob(Job job);
    void removeJob(int id);
    Job getJobByID(int id);
    List<Job> listJobs();
}
