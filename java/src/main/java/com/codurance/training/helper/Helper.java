package com.codurance.training.helper;

import com.codurance.training.commandLine.CommandRunner;

import java.io.PrintWriter;

public class Helper {
    public void help() {
        PrintWriter out= CommandRunner.out;
        out.println("Commands:");
        out.println("  view by project");
        out.println("  view by date");
        out.println("  view by deadline");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println("  deadline <task ID> <date>");
        out.println("  today");
        out.println("  customize <task Id> <new Id>");
        out.println();
    }
}
