/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
class LoginExternalClass {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List <LoginExternalClass> users;
    
  LoginExternalClass(String username, String password, String firstName, String lastName){
          this.username = username;
           this.password = password;
           this.firstName = firstName;
           this.lastName= lastName;
            this.users = new ArrayList<>();
           }

   

      
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

 public String getFirstName(){
    return firstName; 
 }
           public String getLastName(){
               return lastName;
           }
   public String displayRegistration(){
          return "Registration";
 }
    
     public void display(){
            System.out.println("Username: " + username);
              System.out.println("Password: " + password);
               System.out.println("First name: " + firstName);
                System.out.println("Last name: " + lastName);
                                
      }
     
        //method to check username format
         public boolean checkUsername(String username) {
        return username.contains("_") && username.length() == 5;
    }
         // method to check password complexity
  public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               Pattern.compile("[A-Z]").matcher(password).find() &&
               Pattern.compile("[0-9]").matcher(password).find() &&
               Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }
 
        // method to register user

        public  String registerUser( String username, String password, String firstName, String lastName){
        if (!checkUsername(username)) {
            return "username is not correctly formatted, please ensure that your username contains an underscore and is not more than 5 characters in length";
        }
        else if (!checkPasswordComplexity(password)) {
            return "password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, a special character";
        }
  
   users.add(new LoginExternalClass(username, password, firstName, lastName));
    return "Username and password successfully captured.";
}
            // method to login user

        public boolean loginUser(String username, String password) {
        for (LoginExternalClass user : users) {
            if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
// method to return login status
    public String returnLoginStatus(String username, String password) {
        LoginExternalClass loggedInUser = null; 
// To hold the user if login is successful
    for (LoginExternalClass user : users) {
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
            loggedInUser = user; 
            break;
        }
    }
    
    if (loggedInUser != null) {
        return "Welcome " + loggedInUser.getFirstName() + ", " + loggedInUser.getLastName() + "! It is great to see you again.";

    }
    return "Username or password incorrect, please try again.";
}
 
          
}


    

    
