package com.codurance.training.operations.delete;

import com.codurance.training.commandLine.CommandRunner;
import com.codurance.training.task.Task;
import com.codurance.training.task.TaskList;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class DeleteId {
    public void delete(String idString) {
        Map<String, List<Task>> tasks= TaskList.tasks;
        tasks.forEach((project, tasksList) -> {
            tasksList.removeIf(task -> task.getId().equals(idString));
        });
    }
}
