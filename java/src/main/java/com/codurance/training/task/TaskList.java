package com.codurance.training.task;

import com.codurance.training.commandLine.CommandRunner;
import com.codurance.training.error.Error;
import com.codurance.training.helper.Helper;
import com.codurance.training.operations.adder.AddTask;
import com.codurance.training.operations.customize.CustomizeId;
import com.codurance.training.operations.delete.DeleteId;
import com.codurance.training.operations.manage.ManageDeadline;
import com.codurance.training.operations.manage.ManageTask;
import com.codurance.training.operations.showprojects.ShowProjects;
import com.codurance.training.operations.adder.AddProject;
import com.codurance.training.operations.showprojects.TodayProjects;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskList implements TaskListInterface{
    public static long lastId=0;
    public static final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final AddProject addProject =new AddProject();
    private final AddTask addTask =new AddTask();
    private final ShowProjects showProjects=new ShowProjects();
    private final TodayProjects todayProjects =new TodayProjects();
    private final ManageTask manageTask=new ManageTask();
    private final ManageDeadline manageDeadline=new ManageDeadline();
    private final Helper helper=new Helper();
    private final Error error=new Error();
    private final CustomizeId customizeId=new CustomizeId();
    private final DeleteId deleteId=new DeleteId();
    PrintWriter out= CommandRunner.out;

    public void showTaskList(String commandLine){
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[1];
        switch (subcommand) {
            case "project":
                showProjects.byProject();
                break;
            case "date":
                showProjects.byDate();
                break;
            case "deadline":
                showProjects.byDeadline();
                break;
            default:
                out.println("entered wrong command");
                break;
        }
    }

    public void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject.add(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            addTask.add(subcommandRest[1]);
        }
    }

    public void manageTask(String commandLine,String status){
        manageTask.manage(commandLine,status);
    }

    public void manageDeadline(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        manageDeadline.manage(subcommandRest[0],subcommandRest[1]);
    }

    @Override
    public void showTodayProjects() {
        todayProjects.show();
    }

    public void help() {
        helper.help();
    }

    public void error(String command) {
        error.showError(command);
    }

    @Override
    public void customizeId(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        customizeId.customize(subcommandRest[0],subcommandRest[1]);
    }

    @Override
    public void deleteId(String id) {
        deleteId.delete(id);
    }
}
