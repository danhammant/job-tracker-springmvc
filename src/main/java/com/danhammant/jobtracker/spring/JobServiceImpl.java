package com.danhammant.jobtracker.spring;

import com.danhammant.jobtracker.dao.JobDAO;
import com.danhammant.jobtracker.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDAO jobDAO;

    public void setJobDAO(JobDAO jobDAO) {
        this.jobDAO = jobDAO;
    }

    @Override
    @Transactional
    public void addJob(Job job) {
        this.jobDAO.addJob(job);
    }

    @Override
    @Transactional
    public void updateJob(Job job) {
        this.jobDAO.updateJob(job);
    }

    @Override
    @Transactional
    public void removeJob(int id) {
        this.jobDAO.removeJob(id);
    }

    @Override
    @Transactional
    public Job getJobByID(int id) {
        return this.jobDAO.getJobByID(id);
    }

    @Override
    @Transactional
    public List<Job> listJobs() {
        return this.jobDAO.listJobs();
    }
}
