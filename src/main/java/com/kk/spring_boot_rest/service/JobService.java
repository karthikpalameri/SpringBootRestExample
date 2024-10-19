package com.kk.spring_boot_rest.service;

import com.kk.spring_boot_rest.model.JobPost;
import com.kk.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();
    }

    public JobPost getJob(int postId) {
        return jobRepo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobPostList = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Dev", "Java Dev Description", 1, new ArrayList<>(Arrays.asList("Java", "html"))),
                new JobPost(2, "Python", "Python Dev Description", 2, new ArrayList<>(Arrays.asList("Python", "html"))),
                new JobPost(3, "JS", "Js Dev Description", 3, new ArrayList<>(Arrays.asList("JS", "html")))
        ));

        jobRepo.saveAll(jobPostList);
    }

    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
