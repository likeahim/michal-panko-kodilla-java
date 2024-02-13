package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.ForumUser;

import java.util.List;

public class ForumStatistics {

    private Statistics statistics;
    private int forumUsersNumber;
    private int forumPostsNumber;
    private int forumCommentsNumber;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;
    private ForumUser forumUser;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        List<String> usersList = statistics.usersNames();
        forumUsersNumber = usersList.size();
        forumPostsNumber = statistics.postsCount();
        forumCommentsNumber = statistics.commentsCount();
        averagePostsPerUser = (forumUsersNumber == 0 ? 0 : forumPostsNumber / forumUsersNumber);
        averageCommentsPerUser = (forumUsersNumber == 0 ? 0 : forumCommentsNumber/ forumUsersNumber);
        averageCommentsPerPost = (forumPostsNumber == 0 ? 0 : forumCommentsNumber / forumPostsNumber);
    }

    public void showStatistics() {
        System.out.println("Forums statistics:");
        System.out.println("Number of users: " + forumUsersNumber);
        System.out.println("Number of posts: " + forumPostsNumber);
        System.out.println("Number of comments: " + forumCommentsNumber);
        System.out.println("Average posts per user: " + averagePostsPerUser);
        System.out.print("Average comments: per user: " + averageCommentsPerUser);
        System.out.println(" and per post: " + averageCommentsPerPost);
    }

    public int getForumUsersNumber() {
        return forumUsersNumber;
    }

    public int getForumPostsNumber() {
        return forumPostsNumber;
    }

    public int getForumCommentsNumber() {
        return forumCommentsNumber;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    public ForumUser getForumUser() {
        return forumUser;
    }
}
