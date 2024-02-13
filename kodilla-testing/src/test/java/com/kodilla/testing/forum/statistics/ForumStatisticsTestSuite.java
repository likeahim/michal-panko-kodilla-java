package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);

    @BeforeEach
    public void beforeEveryTest() {
        System.out.println("Test begins");
    }

    @AfterEach
    public void printInfo() {forumStatistics.showStatistics();}

    @DisplayName("Posts number = 0")

    @Test
    void testCalculateAdvStatistics0PostCase() {
        //Given
        int numberOfPosts = 0;
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getForumPostsNumber());
    }

    @DisplayName("Posts number = 1000")

    @Test
    void testCalculateAdvStatistics1000PostsCase() {
        //Given
        int numberOfPosts = 1000;
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(1000, forumStatistics.getForumPostsNumber());
    }

    @DisplayName("Comments number = 0")

    @Test
    void testCalculateAdvStatistics0CommentsCase() {
        //Given
        int numberOfComments = 0;
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getForumCommentsNumber());
    }

    @DisplayName("Comments < posts")

    @Test
    void testCalculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        int numberOfPosts = 100;
        int numberOfComments = 50;
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertTrue(forumStatistics.getForumCommentsNumber() < forumStatistics.getForumPostsNumber());
    }

    @DisplayName("Comments > posts")

    @Test
    void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        int numberOfPosts = 50;
        int numberOfComments = 2000;
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertTrue(forumStatistics.getForumCommentsNumber() > forumStatistics.getForumPostsNumber());
    }

    @DisplayName("Users number = 0")

    @Test
    void testCalculateAdvStatistics0UsersCase() {
        //Given
        int numberOfUsers = 0;
        when(statisticsMock.usersNames()).thenReturn(generateNUsersNames(numberOfUsers));

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getForumUsersNumber());
    }

    @DisplayName("Users number = 100")

    @Test
    void testCalculateAdvStatistics100UsersCase() {
        //Given
        int numberOfUsers = 100;
        when(statisticsMock.usersNames()).thenReturn(generateNUsersNames(numberOfUsers));

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getForumUsersNumber());
    }

    private List<String> generateNUsersNames(int n) {
        List<String> resultList = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            resultList.add("User #" + i);
        }
        return resultList;
    }
}
