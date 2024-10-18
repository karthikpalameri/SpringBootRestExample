package com.kk.spring_boot_rest;

import com.kk.spring_boot_rest.model.JobPost;
import com.kk.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller  annotation is generic, it can return jsp
@RestController //for rest no need to explicitly specify @ResponseBody on methods
@CrossOrigin(origins = "http://localhost:3000")
//annotation allows the front-end running on http://localhost:3000 (typically a React application) to make requests to this Spring backend.

/*
@CrossOrigin(origins = {"http://localhost:3000", "http://example.com"},
        methods = {RequestMethod.GET, RequestMethod.POST},
        allowedHeaders = {"Content-Type", "Authorization"},
        allowCredentials = "true")
*/ public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
//    @ResponseBody
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping(value = "jobPost/{postId}", produces = {"application/json"})
    public JobPost getJob(@PathVariable("postId") int postId) {
        return jobService.getJob(postId);
    }

    @PostMapping(value = "jobPost", consumes = {"application/json"})
    public JobPost addJobb(@RequestBody JobPost jobPost) {
        System.out.println("jobPost isss = " + jobPost);
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public void deleteJob(@PathVariable("postId") int postId) {
        jobService.deleteJob(postId);
    }

}
