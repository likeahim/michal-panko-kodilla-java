package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumComment {
    private ForumPost forumPost;
    private String commentBody;
    private String author;

    public ForumComment(ForumPost forumPost, String author, String commentBody) {
        this.forumPost = forumPost;
        this.commentBody = commentBody;
        this.author = author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumComment that = (ForumComment) o;

        if (!Objects.equals(forumPost, that.forumPost)) return false;
        if (!Objects.equals(commentBody, that.commentBody)) return false;
        return Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        int result = forumPost != null ? forumPost.hashCode() : 0;
        result = 31 * result + (commentBody != null ? commentBody.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
