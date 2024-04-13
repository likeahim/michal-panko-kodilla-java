package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.taskList.TaskList;
import com.kodilla.hibernate.taskList.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testTaskDaoSave() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        //When
        taskDao.save(task);
        //Then
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        assertTrue(readTask.isPresent());

        //CleanUp
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoFindByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();
        //When
        List<Task> readTasks = taskDao.findByDuration(duration);

        //Then
        assertEquals(1, readTasks.size());

        //cleanUp
        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoSaveWithFinancialDetails() {
        //Given
        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));

        //When
        taskDao.save(task);
        int id = task.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        taskDao.deleteById(id);
    }

    @Test
    void testNamedQueries() {
        //Given
        Task task1 = new Task("Test: study Hibernate", 3);
        Task task2 = new Task("Test: practice named queries", 6);
        Task task3 = new Task("Test: study native queries", 7);
        Task task4 = new Task("Test: make some tests", 13);
        TaskFinancialDetails tdf1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tdf2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tdf3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tdf4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tdf1);
        task2.setTaskFinancialDetails(tdf2);
        task3.setTaskFinancialDetails(tdf3);
        task4.setTaskFinancialDetails(tdf4);

        TaskList taskList = new TaskList("toDo", "TODO tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);
        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);
        taskListDao.save(taskList);
        int id = taskList.getId();
        //When
        List<Task> longTasks = taskDao.retrieveLongTask();
        List<Task> shortTasks = taskDao.retrieveShortTask();
        List<Task> enoughTimeTasks = taskDao.retrieveTaskWithEnoughTime();

        //Then
        try {
            assertEquals(1, longTasks.size());
            assertEquals(3, shortTasks.size());
            assertEquals(3, enoughTimeTasks.size());
        } finally {
            //CleanUp
            taskListDao.deleteById(id);
        }
    }
}
