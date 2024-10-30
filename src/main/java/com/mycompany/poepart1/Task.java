/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package com.mycompany.poepart1;

/**
 *
 * @author RC_Student_lab
 */public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private double taskDuration;
    private String taskID;
    private String taskStatus;
                   // Constructor to initialize a Task object with provided details

    public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, double taskDuration, String taskStatus) {
              // Assigning constructor parameters to class fields

        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID(); // Call method to create a unique Task ID after all fields are set
    }
                      // Method to create a unique Task ID based on task details

    public String createTaskID() {
        String idPart1 = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String idPart2 = taskNumber > 0 ? String.valueOf(taskNumber) : "0";
        String idPart3 = developerLastName.length() >= 3 ? developerLastName.substring(developerLastName.length() - 3).toUpperCase() : developerLastName.toUpperCase();

        return idPart1 + idPart2 + idPart3;
    }
                                  // Method to print task details in a order format

    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
               "\nDeveloper: " + developerFirstName + " " + developerLastName +
               "\nTask Number: " + taskNumber +
               "\nTask Name: " + taskName +
               "\nDescription: " + taskDescription +
               "\nTask ID: " + taskID +
               "\nDuration: " + String.format("%.1f", taskDuration) + " hours"; // Ensuring one decimal place
    }
                
    // Getter method to retrieve the task's duration
    public double getDuration() {
        return taskDuration;
    }
                // Getter method to retrieve the task's name

    public String getTaskName() {
        return taskName;
    }
}
