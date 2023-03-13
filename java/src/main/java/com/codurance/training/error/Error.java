package com.codurance.training.error;

import com.codurance.training.commandLine.CommandRunner;

import java.io.PrintWriter;


public class Error {
    public void showError(String commandLine) {
        PrintWriter out= CommandRunner.out;
        out.printf("I don't know what the command \"%s\" is.", commandLine);
        out.println();
    }
}
