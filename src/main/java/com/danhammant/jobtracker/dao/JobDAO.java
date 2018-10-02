package com.danhammant.jobtracker.dao;

import com.danhammant.jobtracker.model.Job;

import java.util.List;

public interface JobDAO {

    void addJob(Job job);
    void updateJob(Job job);
    void removeJob(int id);
    Job getJobByID(int id);
    List<Job> listJobs();
}
