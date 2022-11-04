package com.codurance.training.repository;

import com.codurance.training.dto.Task;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ProjectRepository {
    public static HashMap<String, List<Task>> projects = new LinkedHashMap<>();
}
