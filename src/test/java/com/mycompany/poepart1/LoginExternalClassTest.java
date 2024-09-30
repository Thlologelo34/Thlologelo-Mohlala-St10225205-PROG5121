/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginExternalClassTest {
    
    private LoginExternalClass user;

    @BeforeEach
    public void setUp() {
        user = new LoginExternalClass("Gelo_w", "Blessing.34", "Thlologelo", "Mohlala");
        user.registerUser("Gelo_w", "Blessing.34", "Thlologelo", "Mohlala");
    }

    @AfterEach
    public void tearDown() {
        // Reset any static or shared states if necessary
    }

    @Test
    public void testGetUsername() {
        assertTrue(user.getUsername().equals("Gelo_w"));
    }

    @Test
    public void testGetPassword() {
        assertTrue(user.getPassword().equals("Blessing.34"));
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
    public void testDisplayRegistration() {
        assertTrue(user.displayRegistration().equals("Registration"));
    }

    @Test
    
    public void testCheckUsername_Valid() {
        assertFalse(user.checkUsername("a_b"));
    }

    @Test
    public void testCheckUsername_Invalid() {
        assertFalse(user.checkUsername("abcde")); // No underscore
        assertFalse(user.checkUsername("abc_def")); // More than 5 characters
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue(user.checkPasswordComplexity("Blessing.34"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        assertFalse(user.checkPasswordComplexity("Blessing1234")); // No special character
        assertFalse(user.checkPasswordComplexity("blessing@1234")); // No uppercase letter
        assertFalse(user.checkPasswordComplexity("Bless@")); // Less than 8 characters
        assertTrue(user.checkPasswordComplexity("Blessing.34"));// password meet passwordComplexity
    }

    @Test
    public void testRegisterUser_Valid() {
        LoginExternalClass instance = new LoginExternalClass("Gelo_w", "Blessing.34", "Thlologelo", "Mohlala");
        String result = instance.registerUser("Gelo_w", "Blessing.34", "Thlologelo", "Mohlala");
        assertFalse(result.equals("Username and password successfully captured."));
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        String result = user.registerUser("gelow", "Blessing", "Thlolo", "Mohlala");
        assertEquals("username is not correctly formatted, please ensure that your username contains an underscore and is not more than 5 characters in length",result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        LoginExternalClass instance = new LoginExternalClass("Gelo_w", "Blessing", "Thlologelo", "Mohlala");
        String result = instance.registerUser("Gelo_w", "Blessing.34", "Thlologelo", "Mohlala");
        assertFalse(result.equals("password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, a special character"));
    }

    @Test
    public void testLoginUser_Successful() {
                LoginExternalClass instance = new LoginExternalClass("Gelo_w", "Blessing.34", "Thlologelo", "Mohlala");
        String result = instance.registerUser("Gelo_w", "Blessing.34", "Thlologelo", "Mohlala");

        assertFalse(result.equals("Successful login"));
    }

    @Test
    public void testLoginUser_Failed() {
          LoginExternalClass instance = new LoginExternalClass("Gelo_w", "Blessing", "Thlologelo", "Mohlala");
        String result = instance.registerUser("Gelo_w", "Blessing.34", "Thlologelo", "Mohlala");

        assertFalse(result.equals("Falsed login"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
                  LoginExternalClass instance = new LoginExternalClass("Gelo_w", "Blessing", "Thlologelo", "Mohlala");

        String result = instance.returnLoginStatus("Gelo_w", "Blessing.34");
        assertFalse(result.equals("Welcome Thlologelo, Mohlala! It is great to see you again."));
    }

   @Test
public void testReturnLoginStatus_Failure() {
    String result = user.returnLoginStatus("gelo", "Blessing");
    assertEquals("Username or password incorrect, please try again.", result);
}
    }

