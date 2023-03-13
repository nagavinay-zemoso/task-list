package com.codurance.training.operations.manage;

import com.codurance.training.commandLine.CommandRunner;
import com.codurance.training.task.Task;
import com.codurance.training.task.TaskList;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ManageTask implements Manager {
    public void manage(String idString, String done) {
        PrintWriter out= CommandRunner.out;
        Map<String, List<Task>> tasks= TaskList.tasks;
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId().equals(idString)) {
                    task.setDone(done=="true");
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %s.", idString);
        out.println();
    }
}
