package com.codurance.training.operations.manage;

import com.codurance.training.task.Task;
import com.codurance.training.task.TaskList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ManageDeadline implements Manager {
    public void manage(String idString, String deadlineString) {
        Map<String, List<Task>> tasks= TaskList.tasks;
        try{
            for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
                for (Task task : project.getValue()) {
                    if (task.getId().equals(idString)) {
                        Date deadline=new SimpleDateFormat("dd-MM-yyyy").parse(deadlineString);
                        task.setDeadline(deadline);
                        return;
                    }
                }
            }
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
