
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.poepart1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

class TaskManager {
   
    List<Task> tasks;
    private Set<String> developers;
    private Set<String> taskIds;
    private String[] taskNames;
    private String[] developerNames;
    private String[] taskStatuses;
    private double[] taskDurations;
    private int taskCount;
    private int maxSize;
    private Object totalTaskDuration;
// list of arrays with max size of 100
    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.developers = new HashSet<>();
        this.taskIds = new HashSet<>();
        this.taskNames = new String[100];
        this.developerNames = new String[100];
        this.taskStatuses = new String[100];
        this.taskDurations = new double[100];
        this.taskCount = 0;
        this.maxSize = 100;
    }
    
    public List<Task> getTasks() {
        return tasks;
    }


    public void addTask(Task task) {
        if (!taskIds.contains(task.createTaskID())) {
            tasks.add(task);
            developers.add(task.getDeveloperFirstName() + " " + task.getDeveloperLastName());
            taskIds.add(task.createTaskID());
            taskNames[taskCount] = task.getTaskName();
            developerNames[taskCount] = task.getDeveloperFirstName() + " " + task.getDeveloperLastName();
            taskStatuses[taskCount] = task.getTaskStatus();
            taskDurations[taskCount] = task.getDuration();
            taskCount++;
            JOptionPane.showMessageDialog(null, "Task added successfully! Task ID: " + task.createTaskID());
        } else {
            JOptionPane.showMessageDialog(null, "Task ID already exists.");
        }
    }
           //method to  Generates a report of all tasks, including task details.
    public void displayTaskReport() {
        String report = "Task Report:\n";
        for (Task task : tasks) {
            if (task != null) {
                report += task.printTaskDetails() + "\n\n";
            }
        }
        JOptionPane.showMessageDialog(null, report);
    }
   //method displays lists of completed tasks,showing  task with'done' status
    public void displayDoneTasks() {
        String report = "Done Tasks:\n";
        for (Task task : tasks) {
            if (task != null && task.getTaskStatus().equalsIgnoreCase("Done")) {
                report += task.printTaskDetails() + "\n\n";
            }
        }
        JOptionPane.showMessageDialog(null, report);
    }
         //methou to find and displays the longest task ,the longest task's details in a report.
    public void displayLongestTask() {
        Task longestTask = tasks.stream().max((t1, t2) -> Double.compare(t1.getDuration(), t2.getDuration())).orElse(null);
        if (longestTask != null) {
            JOptionPane.showMessageDialog(null, longestTask.printTaskDetails());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks available.");
        }
    }
           // method Searches for a task by name and displays the tasks assigned to the developer with task name,developer and task status

public void searchTaskByName(String taskName) {
    for (Task task : tasks) {
        if (task != null && task.getTaskName().equalsIgnoreCase(taskName)) {
            String taskDetails = "Task Name: " + task.getTaskName() + "\n" +
                                "Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() + "\n" +
                                "Task Status: " + task.getTaskStatus();
            JOptionPane.showMessageDialog(null, taskDetails);
            return;
        }
    }
    JOptionPane.showMessageDialog(null, "Task not found.");
}
       // method searches for tasks assigned to a specific developer Displays the tasks assigned to the developer with task name and task status
public void searchTasksByDeveloper(String developerName) {
    String report = "Tasks by " + developerName + ":\n";
    boolean found = false;
    for (Task task : tasks) {
        if (task != null && (task.getDeveloperFirstName() + " " + task.getDeveloperLastName()).equalsIgnoreCase(developerName)) {
            report += "Task Name: " + task.getTaskName() + "\n" +
                      "Task Status: " + task.getTaskStatus() + "\n\n";
          JOptionPane.showMessageDialog(null, report);
            return;
        }
    }
    JOptionPane.showMessageDialog(null, "Task not found.");
}
   // method to remove task from the task list by task name
    public void deleteTask(String taskName) {
        Task taskToDelete = null;
        for (Task task : tasks) {
            if (task != null && task.getTaskName().equalsIgnoreCase(taskName)) {
                taskToDelete = task;
                break;
            }
        }
        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            taskIds.remove(taskToDelete.createTaskID());
            JOptionPane.showMessageDialog(null, "Task deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
        
    
    }
}