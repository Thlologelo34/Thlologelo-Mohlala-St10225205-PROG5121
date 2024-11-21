/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    private Login user;
    // Set up a default user before each test.
    @BeforeEach
    public void setUp() {
        user = new Login("Kyl_1", "C&&sec@ke99!", "Thlologelo", "Mohlala");
        user.registerUser("kyle!!!!!!!", "Password", "Thlologelo", "Mohlala");
    }

    @AfterEach
    public void tearDown() {
        // Reset any static or shared states if necessary
    }

    @Test
    public void testGetUsername() {
        assertTrue(user.getUsername().equals("Kyl_1"));
    }

    @Test
    public void testGetPassword() {
        assertTrue(user.getPassword().equals("C&&sec@ke99!"));
    }

    @Test
    public void testGetFirstName() {
        assertTrue(user.getFirstName().equals("Thlologelo"));
    }

    @Test
    public void testGetLastName() {
        assertTrue(user.getLastName().equals("Mohlala"));
    }

    @Test
    //        // Ensure that registration display returns the correct message

    public void testDisplayRegistration() {
        assertTrue(user.displayRegistration().equals("Registration"));
    }

    @Test
    
    public void testCheckUsername_Valid() {
        assertTrue(user.checkUsername("Kyl_1"));
    }

    @Test
    public void testCheckUsername_Invalid() {
        assertFalse(user.checkUsername("kyle!!!!!!!")); // No underscore
        assertFalse(user.checkUsername("abc_def")); // More than 5 characters
               

    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue(user.checkPasswordComplexity("C&&sec@ke99!"));
    }
      // Test with passwords that do not meet complexity requirements

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        assertFalse(user.checkPasswordComplexity("password")); // No special character
        assertFalse(user.checkPasswordComplexity("blessing@1234")); // No uppercase letter
        assertFalse(user.checkPasswordComplexity("Bless@")); // Less than 8 characters
        assertTrue(user.checkPasswordComplexity("C&&sec@ke99!"));// password meet passwordComplexity
    }
                   // Test registration with valid username and password

    @Test
    public void testRegisterUser_Valid() {
        Login instance = new Login("Kyl_1", "C&&sec@ke99!", "Thlologelo", "Mohlala");
        String result = instance.registerUser("Kyl_1", "C&&sec@ke99!", "Thlologelo", "Mohlala");
        assertTrue(result.equals("Username and password successfully captured."));
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        String result = user.registerUser("kyle!!!!!!!", "Password", "Thlolo", "Mohlala");
        assertEquals("username is not correctly formatted, please ensure that your username contains an underscore and is not more than 5 characters in length",result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        Login instance = new Login("Kyl_1", "password", "Thlologelo", "Mohlala");
        String result = instance.registerUser("Kyl_1", "C&&sec@ke99!", "Thlologelo", "Mohlala");
        assertFalse(result.equals("password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, a special character"));
    }
                   // Test login with correct credentials

    @Test
    public void testLoginUser_Successful() {
                Login instance = new Login("Kyl_1", "C&&sec@ke99!", "Thlologelo", "Mohlala");
        String result = instance.registerUser("Kyl_1", "C&&sec@ke99!", "Thlologelo", "Mohlala");

        assertFalse(result.equals("Successful login"));
    }

    @Test
    public void testLoginUser_Failed() {
          Login instance = new Login("", "password", "Thlologelo", "Mohlala");
        String result = instance.registerUser("Kyl_1", "C&&sec@ke99!", "Thlologelo", "Mohlala");

        assertFalse(result.equals("Falsed login"));
    }
                 // Verify login status message for successful login

    @Test
    public void testReturnLoginStatus_Success() {
                  Login instance = new Login("Kyl_1", "password", "Thlologelo", "Mohlala");

        String result = instance.returnLoginStatus("Kyl_1", "C&&sec@ke99!");
        assertFalse(result.equals("Welcome Thlologelo, Mohlala! It is great to see you again."));
    }
                // Verify login status message for failed login

   @Test
public void testReturnLoginStatus_Failure() {
    String result = user.returnLoginStatus("kyle!!!!!!", "password");
    assertEquals("Username or password incorrect, please try again.", result);
}
    }

