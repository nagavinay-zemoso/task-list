package com.codurance.training.operations.adder;

import com.codurance.training.commandLine.CommandRunner;
import com.codurance.training.task.Task;
import com.codurance.training.task.TaskList;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class AddTask implements AdderInterface {
    public void add(String commandLine) {
        PrintWriter out= CommandRunner.out;
        Map<String, List<Task>> tasks= TaskList.tasks;
        String[] subcommandRest = commandLine.split(" ", 2);
        String project=subcommandRest[0];
        String description=subcommandRest[1];
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        TaskList.lastId+=1;
        projectTasks.add(new Task(Long.toString(TaskList.lastId), description, false));
    }
}
