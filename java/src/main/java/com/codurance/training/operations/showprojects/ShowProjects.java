package com.codurance.training.operations.showprojects;

import com.codurance.training.commandLine.CommandRunner;
import com.codurance.training.task.Task;
import com.codurance.training.task.TaskList;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ShowProjects implements ShowProjectsInterface {

    private final String pattern = "dd-MM-yyyy";
    private final SimpleDateFormat formatter=new SimpleDateFormat(pattern);
    @Override
    public void byProject() {
        PrintWriter out= CommandRunner.out;
        Map<String, List<Task>> tasks= TaskList.tasks;
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }

    @Override
    public void byDate() {
        Map<String, List<Task>> tasks= TaskList.tasks;
        HashSet<String> dates=new HashSet();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                dates.add(formatter.format(task.getCreatedDate()));
            }
        }

        printProjects(dates,false);
    }

    @Override
    public void byDeadline() {
        Map<String, List<Task>> tasks= TaskList.tasks;
        HashSet<String> deadlines=new HashSet();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if(task.getDeadline()!=null)
                    deadlines.add(formatter.format(task.getDeadline()));
            }
        }

        printProjects(deadlines,true);
    }

    void printProjects(HashSet<String> dates,boolean isDeadline){
        PrintWriter out= CommandRunner.out;
        Map<String, List<Task>> tasks= TaskList.tasks;
        for(String dateString: dates){
            out.println(dateString);
            for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
                for (Task task : project.getValue()) {
                    Date taskDate;
                    if(isDeadline)
                        taskDate=task.getDeadline();
                    else {
                        taskDate=task.getCreatedDate();
                    }
                    if(taskDate!=null)
                        if(dateString.equals(formatter.format(taskDate)))
                            out.printf("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
                }
                out.println();
            }
        }
    }
}
