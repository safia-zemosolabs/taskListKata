package com.codurance.training;

import com.codurance.training.dto.Task;
import com.codurance.training.repository.ProjectRepository;
import com.codurance.training.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskListApplication implements Runnable {
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;

    public AddProject addProject;
    private AddTask addTask;
    private  UpdateTask updateTask;
    private DeleteTask deleteTask;
    private ViewByProject viewByProject;
    private ViewByDeadline viewByDeadline;
    private ViewByDate viewByDate;
    private ViewToday viewToday;

    private  CheckTask checkTask;

    public TaskListApplication(BufferedReader reader, PrintWriter writer,
                               AddProject addProject, AddTask addTask, UpdateTask updateTask, DeleteTask deleteTask,
                               ViewByProject viewByProject, ViewByDeadline viewByDeadline,
                               ViewByDate viewByDate, ViewToday viewToday, CheckTask checkTask ) {
        this.in = reader;
        this.out = writer;

        this.addProject = addProject;
        this.addTask = addTask;
        this.updateTask = updateTask;
        this.deleteTask = deleteTask;

        this.viewByProject = viewByProject;
        this.viewByDeadline = viewByDeadline;
        this.viewByDate = viewByDate;
        this.viewToday = viewToday;

        this.checkTask = checkTask;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        AddProject addProject = new AddProject();
        AddTask addTask = new AddTask();

        UpdateTask updateTask = new UpdateTask();
        DeleteTask deleteTask = new DeleteTask();

        ViewByProject viewByProject = new ViewByProject();
        ViewByDeadline viewByDeadline = new ViewByDeadline();
        ViewByDate viewByDate = new ViewByDate();
        ViewToday viewToday = new ViewToday();

        CheckTask checkTask = new CheckTask();

        new TaskListApplication(in, out,
                                addProject, addTask, updateTask, deleteTask,
                                viewByProject, viewByDeadline,
                                viewByDate, viewToday, checkTask).run();
    }



    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "view_by_project":
                viewByProject.viewBy("");
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                checkTask.check(commandRest[1]);
                break;
            case "uncheck":
                checkTask.unCheck(commandRest[1]);
                break;
            case "deadline":
                updateTask.update(commandRest[1]);
                break;
            case "delete":
                deleteTask.delete(commandRest[1]);
                break;
            case "view_by_deadline":
                viewByDeadline.viewBy("");
                break;
            case "view_by_date":
                viewByDate.viewBy(commandRest[1]);
                break;
            case "today":
                viewToday.viewBy("");
                break;
            case "help":
                help();
                break;
            default:
                error(command);
                break;
        }
    }

    private void add(String commandLine) {

        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];

        if (subcommand.equals("project")) {
            addProject.add(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            addTask.add(subcommandRest[1]);
        }
    }

    private void help() {
        out.println("Commands:");
        out.println("  view_by_project");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task ID> <task description>");
        out.println("  check <project name> <task ID>");
        out.println("  uncheck <project name> <task ID>");
        out.println("  deadline <project name> <task ID> <data>");
        out.println("  delete <project name> <task ID>");
        out.println("  view_by_deadline");
        out.println("  view_by_date <data>");
        out.println("  today");
        out.println();
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

}
