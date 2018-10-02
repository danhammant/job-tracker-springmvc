package com.danhammant.jobtracker.dao;

import com.danhammant.jobtracker.model.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JobDAOImpl implements JobDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addJob(Job job) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(job);
    }

    @Override
    public void updateJob(Job job) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(job);
    }

    @Override
    public void removeJob(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Job job = session.load(Job.class, id);
        if (job != null) {
            session.delete(job);
        }
    }

    @Override
    public Job getJobByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.load(Job.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Job> listJobs() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Job").list();
    }
}
