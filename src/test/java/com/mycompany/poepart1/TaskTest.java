/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private Task task1;
    private Task task2;

    @BeforeAll
    public static void setUpClass() {
        // Code to run once before all tests (if needed)
    }

    @AfterAll
    public static void tearDownClass() {
        // Code to run once after all tests (if needed)
    }

    @BeforeEach
    public void setUp() {
        // Initialize tasks before each test
        task1 = new Task("login feature", 1, "Create login to authenticate users", "Robyn", "Harrison", 8.0, "To Do");
        task2 = new Task("add task features", 2, "Create add task feature to add task users", "Mike", "Smith", 10.0, "Doing");
    }

    @AfterEach
    public void tearDown() {
        // Code to run after each test (if needed)
    }

    private void assertTaskID(Task task, String expectedID) {
        assertEquals(expectedID, task.createTaskID(), "Task ID for " + task.getTaskName() + " should match the expected format.");
    }

    private void assertTaskDetails(Task task, String expectedDetails) {
        assertEquals(expectedDetails, task.printTaskDetails(), "Printed details for " + task.getTaskName() + " do not match expected.");
    }

    @Test
    public void testCreateTaskID() {
        System.out.println("Testing createTaskID");
        assertTaskID(task1, "LO1SON"); // Adjust expected ID as needed
        assertTaskID(task2, "AD2ITH"); // Adjust expected ID as needed
    }
@Test
public void testPrintTaskDetails() {
    System.out.println("Testing printTaskDetails");

    // Assuming createTaskID generates IDs as described previously
    String expectedID1 = task1.createTaskID(); // Dynamically get expected ID
    String expectedID2 = task2.createTaskID(); // Dynamically get expected ID

    String expectedDetails1 = "Task Status: To Do\n" +
                               "Developer: Robyn Harrison\n" +
                               "Task Number: 1\n" +
                               "Task Name: login feature\n" +
                               "Description: Create login to authenticate users\n" +
                               "Task ID: " + expectedID1 + "\n" +  // Use dynamically generated ID
                               "Duration: 8.0 hours";

    String expectedDetails2 = "Task Status: Doing\n" +
                               "Developer: Mike Smith\n" +
                               "Task Number: 2\n" +
                               "Task Name: add task features\n" +
                               "Description: Create add task feature to add task users\n" +
                               "Task ID: " + expectedID2 + "\n" +  // Use dynamically generated ID
                               "Duration: 10.0 hours";

    // Use helper method for assertions
    assertTaskDetails(task1, expectedDetails1);
    assertTaskDetails(task2, expectedDetails2);
}


    @Test
    public void testTotalTaskDuration() {
        double totalDuration = task1.getDuration() + task2.getDuration();
        assertEquals(18.0, totalDuration, 0.001); // 8.0 + 10.0 = 18.0
    }

    @Test
    public void testGetDuration() {
        System.out.println("Testing getDuration");
        double expResult = 8.0; // Expected duration for task1
        double result = task1.getDuration();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testGetTaskName() {
        System.out.println("Testing getTaskName");
        String expResult = "login feature"; // Expected name for task1
        String result = task1.getTaskName();
        assertEquals(expResult, result);
    }
}
