package com.codurance.training.service;

import com.codurance.training.repository.ProjectRepository;
import com.codurance.training.service.AddService;
import com.codurance.training.dto.Task;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public final class AddTask implements AddService {

    @Override
    public void add(String cmdArg) {
        String[] commandRest = cmdArg.split(" ", 3);
        String projectName = commandRest[0];
        String id = commandRest[1];
        String description = commandRest[2];

        List<Task> projectTasks = ProjectRepository.projects.get(projectName);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", projectName);
            out.println();
            return;
        }

        String[] descriptionDetails = description.split(" ", 2);

        if(descriptionDetails.length > 1){
            description = descriptionDetails[0];
            String deadline = descriptionDetails[1];
            projectTasks.add(new Task(id,projectName, description, false,deadline));
        } else {
            projectTasks.add(new Task(id,projectName, description, false));
        }

    }


}