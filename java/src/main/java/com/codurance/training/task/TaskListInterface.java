package com.codurance.training.task;

import java.text.ParseException;

public interface TaskListInterface {
    void showTaskList(String commandLine);
    void add(String commandLine);
    void manageTask(String commandLine,String status);
    void manageDeadline(String commandLine) throws ParseException;
    void showTodayProjects();
    void help();
    void error(String commandLine);
    void customizeId(String commandLine);
    void deleteId(String commandLine);
}
