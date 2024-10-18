package com.kk.spring_boot_rest.repo;

import com.kk.spring_boot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    private List<JobPost> jobPostList = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Dev", "Java Dev Description", 1, new ArrayList<>(Arrays.asList("Java", "html"))),
            new JobPost(2, "Python", "Python Dev Description", 2, new ArrayList<>(Arrays.asList("Python", "html"))),
            new JobPost(3, "JS", "Js Dev Description", 3, new ArrayList<>(Arrays.asList("JS", "html")))
    ));

    public List<JobPost> getAllJobs() {
        return jobPostList;
    }

    public void addJob(JobPost jobPost) {
        jobPostList.add(jobPost);
        System.out.println("After adding , jobPost = " + jobPostList);
    }

    public JobPost getJob(int postId) {
        for (JobPost jobPost : jobPostList) {
            if (jobPost.getPostId() == postId) {
                return jobPost;
            }
        }
        return null;
    }

    public void updateJobb(JobPost jobPost) {
        for (JobPost post : jobPostList) {
            if (post.getPostId() == jobPost.getPostId()) {
                post.setPostId(jobPost.getPostId());
                post.setPostDesc(jobPost.getPostDesc());
                post.setPostProfile(jobPost.getPostProfile());
                post.setPostTechStack(jobPost.getPostTechStack());
                post.setReqExperience(jobPost.getReqExperience());
                System.out.println("Updated jobPost = " + jobPost);
            }
        }
    }

    public void deleteJob(int postId) {
        jobPostList.removeIf(x -> x.getPostId() == postId);
        System.out.println("Deleted postId = " + postId);

        // bad code to iterate and remove which will result in java.util.ConcurrentModificationException: null either user iterator to remove or streams
/*
        for (JobPost jobPost : jobPostList) {
            if (jobPost.getPostId() == postId) {
                jobPostList.remove(jobPost);
                System.out.println("Deleted postId = " + postId);
            }
        }
*/
    }
}
