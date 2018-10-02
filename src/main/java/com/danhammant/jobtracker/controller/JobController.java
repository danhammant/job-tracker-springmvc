package com.danhammant.jobtracker.controller;

import com.danhammant.jobtracker.model.Job;
import com.danhammant.jobtracker.spring.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(path = "/jobs")
    public String listJobs(Model model) {
        model.addAttribute("job", new Job());
        model.addAttribute("jobList", this.jobService.listJobs());
        return "job";
    }

    @PostMapping(path = "/job/add")
    public String addJob(@ModelAttribute("job") Job job) {
        if (job.getId() == 0) {
            this.jobService.addJob(job);
        } else {
            this.jobService.updateJob(job);
        }
        return "redirect:/jobs";
    }

    @RequestMapping(path = "/job/remove/{id}")
    public String removeJob(@PathVariable("id") int id) {
        this.jobService.removeJob(id);
        return "redirect:/jobs";
    }

    @RequestMapping(path = "/job/edit/{id}")
    public String editJob(@PathVariable("id") int id, Model model) {
        model.addAttribute("job", this.jobService.getJobByID(id));
        model.addAttribute("jobList", this.jobService.listJobs());
        return "job";
    }

}
