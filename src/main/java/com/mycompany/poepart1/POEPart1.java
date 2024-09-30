/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;



/**
 *
 * @author RC_Student_lab
 */
public class POEPart1 {
       public static void main(String[]args){
           Scanner sc = new Scanner(System.in);
           
               
                LoginExternalClass login = new LoginExternalClass("Gelo_w","Blessing.34","Thlologelo","Mohlala");
             login.display();
           while(true){
            System.out.println("1. Register");
            
        
         System.out.println("2.Login");
                  
                           System.out.println("3.Exit");
                                    System.out.println("choose an option");
          int option = sc.nextInt();
          switch(option){
              case 1:
                        //Register User   
           System.out.println("Enter Username:");
           String username = sc.next();
                System.out.println("Enter password:");
                String password = sc.next();
                                System.out.println("Enter First name:");
                                String firstName = sc.next();
                         System.out.println("Enter Last name:");
                         String lastName = sc.next();
                         String registrationResult = login.registerUser(username, password, firstName, lastName);
                    System.out.println(registrationResult);
                    // Print registration result
                    break;
case 2:
                    // Login User
                    System.out.print("Enter Username to Login: ");
                    String loginUsername = sc.next();
                    
                    System.out.print("Enter Password to Login: ");
                    String loginPassword = sc.next();
                    
                    String loginResult = login.returnLoginStatus(loginUsername, loginPassword);
                    System.out.println(loginResult);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    
                    return; 
                  // Exit the program

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
      
                              
                    
       



