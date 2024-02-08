package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {
    private static int testCounter = 0;
    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class PostTests {
        @Test
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("johnny", "John Smith");

            //When
            forumUser.addPost("johnny", "Hello everyone, this is my first contribution here");

            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("johnny", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here", "johnny");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);

            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }

        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("johnny", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here", "johnny");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }

        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("johnny", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here", "johnny");

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertFalse(result);
        }
    }
    @Nested
    @DisplayName("Tests for comments")
    class CommentsTest {
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("johnny", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here", "johnny");

            //When
            forumUser.addComment(thePost, "johnny", "Thank you for good words");

            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("johnny", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here", "johnny");
            ForumComment theComment = new ForumComment(thePost, "johnny", "Thank you for good words");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("johnny", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here", "johnny");
            ForumComment theComment = new ForumComment(thePost, "johnny", "Thank you for good words");

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("johnny", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here", "johnny");
            ForumComment theComment = new ForumComment(thePost, "johnny", "Thank you all for good words");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}
