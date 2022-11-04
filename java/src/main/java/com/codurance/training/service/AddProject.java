package com.codurance.training.service;

import com.codurance.training.dto.Task;
import com.codurance.training.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AddProject implements AddService{
    @Override
    public void add(String cmdArg) {

        ProjectRepository.projects.put(cmdArg, new ArrayList<Task>());
    }
}
