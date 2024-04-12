package com.kodilla.hibernate.taskList.dao;

import com.kodilla.hibernate.taskList.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;
    private static final String NAME = "TestList";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(NAME, "list to testing");
        //When
        taskListDao.save(taskList);

        //Then
        String nameToFind = taskList.getListName();
        List<TaskList> readTaskList = taskListDao.findByListName(nameToFind);
        assertEquals(1, readTaskList.size());

        //cleanUp
        int id = taskList.getId();
        taskListDao.deleteById(id);
    }
}
