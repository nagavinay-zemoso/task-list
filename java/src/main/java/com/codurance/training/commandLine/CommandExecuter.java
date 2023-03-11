package com.codurance.training.commandLine;

import com.codurance.training.task.TaskList;

import java.io.PrintWriter;

public class CommandExecuter {
    private final TaskList taskList=new TaskList();
    PrintWriter out= CommandRunner.out;
    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "view":
                taskList.showTaskList(commandRest[1]);
                break;
            case "add":
                taskList.add(commandRest[1]);
                break;
            case "check":
                taskList.manageTask(commandRest[1],"true");
                break;
            case "uncheck":
                taskList.manageTask(commandRest[1],"false");
                break;
            case "help":
                taskList.help();
                break;
            case "deadline":
                taskList.manageDeadline(commandRest[1]);
                break;
            case "today":
                taskList.showTodayProjects();
                break;
            case "customize":
                taskList.customizeId(commandRest[1]);
                break;
            case "delete":
                taskList.deleteId(commandRest[1]);
                break;
            default:
                taskList.error(command);
                break;
        }
    }
}

