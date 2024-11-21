/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */package com.mycompany.poepart1;

import javax.swing.JOptionPane;

public class POEPart1 {

    public static void main(String[] args) {
        Login login = new Login("Ge_lo", "Blessing.34", "Thlologelo", "Mohlala");
        String loggedInUsername = null;
                             // Continuously prompt user for login or registration until successful login.

        while (loggedInUsername == null) {
                           // Display login and registration options to user with clear instructions.

            String optionStr = JOptionPane.showInputDialog("1. Register\n2. Login\n3. Exit\nChoose an option:");
            if (optionStr == null) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                return; 
            }
 // Attempt to parse user input into integer for option selection
            int option;
            try {
                option = Integer.parseInt(optionStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1: 
                    // prompt the user to enter username, password, firstname and lastname to register.
                    String username = JOptionPane.showInputDialog("Enter Username:");
                    String password = JOptionPane.showInputDialog("Enter Password:");
                    String firstName = JOptionPane.showInputDialog("Enter First Name:");
                    String lastName = JOptionPane.showInputDialog("Enter Last Name:");
                    String registrationResult = login.registerUser(username, password, firstName, lastName);
                    JOptionPane.showMessageDialog(null, registrationResult);
                    break;

                case 2: 
                    // prompt the user to enter useranem and password to login
                    String loginUsername = JOptionPane.showInputDialog("Enter Username to Login:");
                    String loginPassword = JOptionPane.showInputDialog("Enter Password to Login:");
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
                  //after user logged in the application display 'welcome to Easykanban'
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban, " + loggedInUsername);
       

        TaskManager taskManager = new TaskManager();

        int choice = 0;

        do {
                        // Display task management options with clear instructions.

            String choiceStr = JOptionPane.showInputDialog("Select option:\n1. Add tasks\n2. Show report\n3. Display done tasks\n4. Display longest task\n5. Search task by name\n6. Search tasks by developer\n7. Delete task\n8. Quit");
            if (choiceStr == null) break;

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                continue;
            }
                                     // Attempt to parse user input into integer for option selection.

            switch (choice) {
                case 1:
                    int numTasks;
                    try {
                        numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid number of tasks.");
                        continue;
                    }
                          // Loop to create multiple tasks
                    for (int i = 0; i < numTasks; i++) {
                        String taskName = JOptionPane.showInputDialog("Enter task name:");
                        String taskDescription;
                        while (true) {
                            taskDescription = JOptionPane.showInputDialog("Enter task description:");
                            if (taskDescription.length() <= 50) break;
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                        }

                        if (taskDescription == null) break; 
                                  // Prompt user to enter developer details

                        String developerFirstName = JOptionPane.showInputDialog("Enter developer first name:");
                        String developerLastName = JOptionPane.showInputDialog("Enter developer last name:");
                        double taskDuration;
                        while (true) {
                            try {
                                    // Validate task duration (non-negative number)

                                taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter task duration:"));
                                if (taskDuration < 0) {
                                    JOptionPane.showMessageDialog(null, "Duration cannot be negative.");
                                } else break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid input for duration.");
                            }
                        }
                       
                        String taskStatus;
                        while (true) {
                          // Display a menu for the user to choose the task status.
                            String statusInput = JOptionPane.showInputDialog("Select task status:\n1. To Do\n2. Done\n3. Doing");
                            switch (statusInput) {
                                case "1": taskStatus = "To Do"; break;
                                case "2": taskStatus = "Done"; break;
                                case "3": taskStatus = "Doing"; break;
                                default: 
                                    JOptionPane.showMessageDialog(null, "Invalid status. Please select a valid option.");
                                    continue;
                            }
                            break;
                        }
                          
                        Task task = new Task(taskName, taskManager.tasks.size() + 1, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);
                        taskManager.addTask(task);
                        JOptionPane.showMessageDialog(null, "Task added successfully! Task ID: " + task.createTaskID());
                    }
                    
                  

                  
                case 2:
                    taskManager.displayTaskReport();
                    break;

                case 3:
                                        // Display tasks with 'Done' status.

                    taskManager.displayDoneTasks();
                    break;

                case 4:
                    // display the longestTask durationg between the task that are provides
                    taskManager.displayLongestTask();
                    break;

             case 5:
                                     // Search tasks by name with validated input.

                    String searchTaskName = JOptionPane.showInputDialog("Enter task name to search:");
                    taskManager.searchTaskByName(searchTaskName);
                    break;

                case 6:
                                        // Search tasks by developer with validated input.

                    String searchDeveloperName = JOptionPane.showInputDialog("Enter developer name to search:");
                    taskManager.searchTasksByDeveloper(searchDeveloperName);
                    break;
                                        // Delete task with validated input.

                case 7:
                    String deleteTaskName = JOptionPane.showInputDialog("Enter task name to delete:");
                    taskManager.deleteTask(deleteTaskName);
                    break;

                case 8:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.");
            }
            
        } while (choice != 8);
    }
}