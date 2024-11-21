/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    private Task task1;
    private Task task2;
           // Set up test objects before each test, Initialize two tasks with predefined values for testing
    @BeforeEach
    public void setUp() {
        task1 = new Task("login feature", 1, "Create login to authenticate users", "Robyn", "Harrison", 8.0, "To Do");
        task2 = new Task("add task features", 2, "Create add task feature to add task users", "Mike", "Smith", 10.0, "Doing");
    }

    @AfterEach
    public void tearDown() {
        task1 = null;
        task2 = null;
    }

       // test that the createTaskID method generates the expected unique task ID.
    @Test
    public void testCreateTaskID_ReturnsExpectedID() {
        String expectedID1 = "LO1SON";
        String expectedID2 = "AD2ITH";
        assertEquals(expectedID1, task1.createTaskID());
        assertEquals(expectedID2, task2.createTaskID());
    }

    // Test that the printTaskDetails method returns a formatted string with all task details.
     
    @Test
    public void testPrintTaskDetails_ReturnsExpectedDetails() {
        String expectedID1 = task1.createTaskID();
        String expectedID2 = task2.createTaskID();

        String expectedDetails1 = "Task Status: To Do\n" +
                "Developer: Robyn Harrison\n" +
                "Task Number: 1\n" +
                "Task Name: login feature\n" +
                "Description: Create login to authenticate users\n" +
                "Task ID: " + expectedID1 + "\n" +
                "Duration: 8.0 hours";

        String expectedDetails2 = "Task Status: Doing\n" +
                "Developer: Mike Smith\n" +
                "Task Number: 2\n" +
                "Task Name: add task features\n" +
                "Description: Create add task feature to add task users\n" +
                "Task ID: " + expectedID2 + "\n" +
                "Duration: 10.0 hours";

        assertEquals(expectedDetails1, task1.printTaskDetails());
        assertEquals(expectedDetails2, task2.printTaskDetails());
    }

    // Test that getDuration returns the correct duration value for a task.
    @Test
    public void testGetDuration_ReturnsExpectedDuration() {
        double expectedDuration = 8.0;
        double actualDuration = task1.getDuration();
        assertEquals(expectedDuration, actualDuration, 0.001);
    }

    // Test that getTaskName retrieves the correct task name.
    @Test
    public void testGetTaskName_ReturnsExpectedName() {
        String expectedName = "login feature";
        String actualName = task1.getTaskName();
        assertEquals(expectedName, actualName);
    }
            // Test that getTaskStatus retrieves the correct task status.
   
    @Test
    public void testGetTaskStatus_ReturnsExpectedStatus() {
        String expectedStatus = "To Do";
        String actualStatus = task1.getTaskStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    // Test that getDeveloperFirstName retrieves the correct first name of the developer.
     
    @Test
    public void testGetDeveloperFirstName_ReturnsExpectedFirstName() {
        String expectedFirstName = "Robyn";
        String actualFirstName = task1.getDeveloperFirstName();
        assertEquals(expectedFirstName, actualFirstName);
    }

           // Test that getDeveloperLastName retrieves the correct last name of the developer.
    @Test
    public void testGetDeveloperLastName_ReturnsExpectedLastName() {
        String expectedLastName = "Harrison";
        String actualLastName = task1.getDeveloperLastName();
        assertEquals(expectedLastName, actualLastName);
    }
}