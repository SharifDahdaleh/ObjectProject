/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectProject;

import java.util.Scanner;
/**
 *
 * @author SharifDahdaleh
 */
public class TurtleSimulator {
    static Scanner userInput = new Scanner (System.in);
    static boolean loopBreak = false;
    static int userChoice;
    public static void main(String[] args) {
        
        System.out.println("*** WELCOME TO TURTLE SIMULATOR ***");
        PetTurtle newTurtle = new PetTurtle();
        System.out.println("Enter your turtle's name: ");
        newTurtle.turtleName = userInput.nextLine();

        newTurtle.setFoodSupply();
        
        while (loopBreak == false) {
            options();
            switch (userChoice) {
                case 1:
                    newTurtle.getLocation();
                    break;
                case 2:
                    newTurtle.getIsHungry();
                    break;
                case 3:
                    newTurtle.feedTurtle();
                    break;
                case 4:
                    System.out.println("Current food supply: " 
                            + newTurtle.outputFoodSupply()); 
                    break;
                default:
                    loopBreak = true;
                    break;
            }//end switch
            newTurtle.statusReport();
            
            if (newTurtle.checkIfDead() == true) {
                loopBreak = true;
            }//end if
        }//end loop
        
    }//end main
    
    public static void options() {
        System.out.println("Choose what you want to check on: ");
        System.out.println("Type in the number corresponding to the choice");
        System.out.println("1: Location");
        System.out.println("2: Hunger Status");
        System.out.println("3: Feed the turtle");
        System.out.println("4: Check food supply");
        System.out.println("Type in any other number to quit");
        int choice = userInput.nextInt();
        userChoice = choice;
    }//end options
}//end class

