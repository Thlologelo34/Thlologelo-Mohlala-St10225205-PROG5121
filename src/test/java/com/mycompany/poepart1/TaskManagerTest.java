/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */package com.mycompany.poepart1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;

import java.util.List;

public class TaskManagerTest {

    private TaskManager taskManager;
   //Sets up the test environment before each test, Initializes a TaskManager instance and adds sample tasks.
    @BeforeEach
    public void setUp() {
               // Add sample tasks with varying statuses and durations

        taskManager = new TaskManager();
        taskManager.addTask(new Task("Create Login", 1, "", "Mike", "Smith", 5, "Done"));
        taskManager.addTask(new Task("Create Add Features", 2, "", "Edward", "Harrison", 8, "Doing"));
        taskManager.addTask(new Task("Create Report", 3, "", "Samantha", "Paulson", 2, "Done"));
        taskManager.addTask(new Task("Add Arrays", 4, "", "Glenda", "Oberholzer", 11, "To Do"));
    }

    @AfterEach
    public void tearDown() {
        taskManager = null;
    }


    @Test
    public void testAddDuplicateTask() {
        Task duplicateTask = new Task("Create Login", 1, "", "Mike", "Smith", 5, "Done");
        taskManager.addTask(duplicateTask);

        // Verify that the task count doesn't increase after adding a duplicate
        List<Task> tasks = taskManager.getTasks();
        assertEquals(4, tasks.size(), "Task count should not increase when adding a duplicate.");
    }
                    // Tests displaying the task report, Verifies that the report contains the correct number of tasks.
    @Test
    public void testDisplayTaskReport() {
        taskManager.displayTaskReport();

        // Verify that the task report displays correct task count
        assertEquals(4, taskManager.getTasks().size(), "Task report should contain 4 tasks.");
    }
    // tests searching by task name to display developer, task name and task status
    @Test
    public void testSearchTaskByName() {
        taskManager.searchTaskByName("Create Login");

        
    }
   //Tests searching for tasks by developer to display task name and task status
    @Test
    public void testSearchTasksByDeveloper() {
        taskManager.searchTasksByDeveloper("Edward Harrison");

        // Again, this involves a JOptionPane, so UI output isn't directly testable without mocking.
    }

    @Test
    public void testDeleteTask() {
        taskManager.deleteTask("Create Report");

        List<Task> tasks = taskManager.getTasks();
        assertEquals(3, tasks.size(), "Task count should be 3 after deletion.");
        assertFalse(tasks.stream().anyMatch(task -> task.getTaskName().equalsIgnoreCase("Create Report")),
                    "Task 'Create Report' should no longer exist.");
    }
                
    @Test
    public void testDeleteNonExistingTask() {
        taskManager.deleteTask("Non Existing Task");

        List<Task> tasks = taskManager.getTasks();
        assertEquals(4, tasks.size(), "Task count should remain 4 after attempting to delete a non-existing task.");
    }
      // test to diplays the logest task duration between the task provided
    @Test
    public void testDisplayLongestTask() {
        taskManager.displayLongestTask();

    }
}
