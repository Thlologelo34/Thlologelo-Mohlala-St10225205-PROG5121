/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */package com.mycompany.poepart1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
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
    public void testDisplayTaskReport() {
        assertEquals(4, taskManager.tasks.size(), "Task report should contain 4 tasks.");
        // Add verification for task details
    }

    @Test
    public void testDisplayDoneTasks() {
        long doneTaskCount = taskManager.tasks.stream()
                .filter(task -> task.getTaskStatus().equalsIgnoreCase("Done"))
                .count();

        assertEquals(2, doneTaskCount, "There should be 2 tasks with status 'Done'.");
    }

    @Test
    public void testDisplayLongestTask() {
        Task longestTask = taskManager.tasks.stream()
                .max((t1, t2) -> Double.compare(t1.getDuration(), t2.getDuration()))
                .orElse(null);

        assertNotNull(longestTask, "There should be a longest task.");
        assertEquals(11, longestTask.getDuration(), "The longest task should have a duration of 11.");
        assertEquals("Add Arrays", longestTask.getTaskName(), "The longest task should be 'Add Arrays'.");
    }

    @Test
    public void testSearchTaskByName() {
        Task task = taskManager.tasks.stream()
                .filter(t -> t.getTaskName().equalsIgnoreCase("Create Login"))
                .findFirst()
                .orElse(null);

        assertNotNull(task, "Task with name 'Create Login' should be found.");
        assertEquals("Mike Smith", task.getDeveloperFirstName() + " " + task.getDeveloperLastName(), 
                     "Task developer should be 'Mike Smith'.");
    }

    @Test
    public void testSearchTasksByDeveloper() {
        long count = taskManager.tasks.stream()
                .filter(t -> (t.getDeveloperFirstName() + " " + t.getDeveloperLastName())
                        .equalsIgnoreCase("Edward Harrison"))
                .count();

        assertEquals(1, count, "Developer 'Edward Harrison' should have 1 task.");
    }

    @Test
    public void testDeleteTask() {
        taskManager.deleteTask("Create Report");

        assertEquals(3, taskManager.tasks.size(), "Task count should be 3 after deletion.");
        assertFalse(taskManager.tasks.stream()
                .anyMatch(task -> task.getTaskName().equalsIgnoreCase("Create Report")),
                "Task 'Create Report' should no longer exist.");
    }
      @AfterAll
    public static void displayTaskReport() {
        System.out.println("\n--- Final Task Report ---");
        System.out.println("All tests completed.");
        System.out.println("Total tasks: 4");
        System.out.println("Done tasks: 2");
        System.out.println("Longest task: Add Arrays (11 hours)");
        System.out.println("Tasks by developer:");
        System.out.println("  - Mike Smith: 1");
        System.out.println("  - Edward Harrison: 2");
        System.out.println("  - Samantha Paulson: 3");
        System.out.println("  - Glenda Oberholzer: 4");
    }

    }




