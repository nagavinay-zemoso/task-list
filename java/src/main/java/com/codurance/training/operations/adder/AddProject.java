package com.codurance.training.operations.adder;

import com.codurance.training.commandLine.CommandRunner;
import com.codurance.training.task.Task;
import com.codurance.training.task.TaskList;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddProject implements AdderInterface{
    public void add(String commandLine) {
        String name=commandLine;
        Map<String, List<Task>> tasks= TaskList.tasks;
        tasks.put(name, new ArrayList<>());
    }
}
