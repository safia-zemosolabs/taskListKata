package com.codurance.training.service;

import com.codurance.training.dto.Task;
import com.codurance.training.repository.ProjectRepository;

import java.util.List;
import java.util.Map;

public class UpdateTask implements UpdateService{
      @Override
    public void update(String cmdArg) {
        String[] commandRest = cmdArg.split(" ", 3);
        String projectName = commandRest[0];
        String targetTaskId = commandRest[1];
        String deadline = commandRest[2];

        List<Task> projectTasks = ProjectRepository.projects.get(projectName);

        for(int i = 0; i < projectTasks.size(); i++){
            if(projectTasks.get(i).getId().equals(targetTaskId)){
                projectTasks.get(i).setDeadline(deadline);
            }
        }
    }
}
