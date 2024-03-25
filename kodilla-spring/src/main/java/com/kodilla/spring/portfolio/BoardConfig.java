package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public Board getBoard () {
        return new Board(makeToDoList(), makeInProgressList(), makeDoneList());
    }

    @Bean(name="toDoList")
    public TaskList makeToDoList() {
        return new TaskList();
    }

    @Bean(name="inProgressList")
    public TaskList makeInProgressList() {
        return new TaskList();
    }

    @Bean(name="doneList")
    public TaskList makeDoneList() {
        return new TaskList();
    }
}
