/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */package com.mycompany.poepart1;

import javax.swing.JOptionPane;

public class POEPart1 {

    public static void main(String[] args) {
        LoginExternalClass login = new LoginExternalClass("Ge_lo", "Blessing.34", "Thlologelo", "Mohlala");
                  // Variable to hold the username of the logged-in user
        String loggedInUsername = null;

        while (loggedInUsername == null) {
            // Show options for registration, login, or exit
            String optionStr = JOptionPane.showInputDialog("1. Register\n2. Login\n3. Exit\nChoose an option:");
            if (optionStr == null) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                return; // Exit if Cancel is pressed
            }

            int option;
            try {
                option = Integer.parseInt(optionStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1: // Register User
                    String username = JOptionPane.showInputDialog("Enter Username:");
                    String password = JOptionPane.showInputDialog("Enter Password:");
                    String firstName = JOptionPane.showInputDialog("Enter First Name:");
                    String lastName = JOptionPane.showInputDialog("Enter Last Name:");
                    // Call the registration method and show the result
                    String registrationResult = login.registerUser(username, password, firstName, lastName);
                    JOptionPane.showMessageDialog(null, registrationResult);
                    break;

                case 2: // Login User
                    String loginUsername = JOptionPane.showInputDialog("Enter Username to Login:");
                    String loginPassword = JOptionPane.showInputDialog("Enter Password to Login:");
                      // Call the login method and get the result
                    String loginResult = login.returnLoginStatus(loginUsername, loginPassword);
                    JOptionPane.showMessageDialog(null, loginResult);
                    if (loginResult.contains("Welcome")) {
                        loggedInUsername = loginUsername;
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
                  
        // Welcome message for the logged-in user
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban, " + loggedInUsername);

        // Task management section
        Task[] tasks = new Task[10];
        int taskCount = 0;
        double totalTaskDuration = 0; // To accumulate total task hours

        int choice = 0;

        do {
            String choiceStr = JOptionPane.showInputDialog("Select option:\n1. Add tasks\n2. Show report\n3. Quit");
            if (choiceStr == null) break;

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Prompt the user for number of tasksthey wish to add
                    int numTasks;
                    try {
                        numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid number of tasks.");
                        continue;
                    }

                    for (int i = 0; i < numTasks && taskCount < tasks.length; i++) {
                        String taskName = JOptionPane.showInputDialog("Enter task name:");
                        String taskDescription;

                        while (true) {
                            taskDescription = JOptionPane.showInputDialog("Enter task description:");
                            if (taskDescription == null) break; // Exit if canceled
                            if (taskDescription.length() <= 50) break;
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                        }

                        if (taskDescription == null) break; // Break if user canceled

                        String developerFirstName = JOptionPane.showInputDialog("Enter developer First name:");
                        String developerLastName = JOptionPane.showInputDialog("Enter developer Last name:");
                        double taskDuration = -1;

                        while (taskDuration < 0) {
                            String durationInput = JOptionPane.showInputDialog("Enter task duration in hours:");
                            try {
                                taskDuration = Double.parseDouble(durationInput);
                                if (taskDuration < 0) {
                                    JOptionPane.showMessageDialog(null, "Duration cannot be negative.");
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid input for duration.");
                            }
                        }

                        String taskStatus;
                        while (true) {
                            String statusInput = JOptionPane.showInputDialog("Select task status:\n1. To Do\n2. Done\n3. Doing");
                            switch (statusInput) {
                                case "1": taskStatus = "To Do"; break;
                                case "2": taskStatus = "Done"; break;
                                case "3": taskStatus = "Doing"; break;
                                default: continue;
                            }
                            break;
                        }

                                               // Create and add the task to the array

                       if (taskCount < tasks.length) { 
    tasks[taskCount] = new Task(taskName, taskCount + 1, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);
    totalTaskDuration += taskDuration; 
    JOptionPane.showMessageDialog(null, "Task added successfully! Task ID: " + tasks[taskCount].createTaskID());

    // Display task details in specified order
    String taskDetails = "Task Status: " + taskStatus +
                         "\nDeveloper: " + developerFirstName + " " + developerLastName +
                         "\nTask Number: " + (taskCount + 1) +
                         "\nTask Name: " + taskName +
                         "\nDescription: " + taskDescription +
                         "\nTask ID: " + tasks[taskCount].createTaskID() +
                         "\nDuration: " + taskDuration + " hours";
    JOptionPane.showMessageDialog(null, taskDetails);
    
    taskCount++; // Increment task count after adding the task
} else {
    JOptionPane.showMessageDialog(null, "Error: Task array is full.");
}

                        
                        if (taskCount >= tasks.length) {
                            JOptionPane.showMessageDialog(null, "Task limit reached! Cannot add more tasks.");
                            break;
                        }
                    }

                    // Display total task duration after entering all tasks
                    JOptionPane.showMessageDialog(null, "Total Task Duration: " + totalTaskDuration + " hours");
                    break;

                case 2:
                    // Show report to diplay "coming soon' message
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting Task Management.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.");
            }
        } while (choice != 3);
    }
}




        