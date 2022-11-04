package com.codurance.training.service;

import com.codurance.training.dto.Task;
import com.codurance.training.repository.ProjectRepository;

import java.util.List;

public class DeleteTask implements DeleteService{
    @Override
    public void delete(String cmdArg){
        String[] commandRest = cmdArg.split(" ", 2);
        String projectName = commandRest[0];
        String targetTaskId = commandRest[1];

        List<Task> projectTasks = ProjectRepository.projects.get(projectName);

        for(int i = 0; i < projectTasks.size(); i++){
            if(projectTasks.get(i).getId().equals(targetTaskId)){
                projectTasks.remove(i);

            }
        }

    }
}
