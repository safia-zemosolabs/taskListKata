package com.codurance.training.service;

import com.codurance.training.dto.Task;
import com.codurance.training.repository.ProjectRepository;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ViewByDeadline implements ViewService {

    private final PrintWriter out = new PrintWriter(System.out);

    @Override
    public void viewBy(String cmdArg) {
        for(Map.Entry<String, List<Task>> project : ProjectRepository.projects.entrySet()) {
            System.out.println(project.getKey());
            for(Task task : project.getValue()) {

                if(task.getDeadline() != null) {
                    System.out.printf("    [%c] %s: %s %s%n",
                                           (task.isDone() ? 'x' : ' '), task.getId(),
                                           task.getDescription(), task.getDeadline() );
                }
            }
            System.out.println();

        }
    }
}
