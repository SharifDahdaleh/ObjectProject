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
public class PetTurtle {
    public String turtleName;
    private String location = "Sitting on the king's rock";
    private int isHungry = 0;
    private int foodSupply;
    private int turtleHappiness = 0;
    private boolean isDead = false;
    
    //counter used to grant multiple options and multiple runs
    public int counter = 0;
    //loopBreak will be used to reset the counter without any problems
    public boolean loopBreak = false;
    
    Scanner userInput = new Scanner(System.in);
    
    //These two methods will use counter to get through the options
    public void getLocation() {
        while (loopBreak == false) {
           switch (counter) {
                    case 0, 3, 6:
                        System.out.println(turtleName + " is swimming around "
                                + "gleefully");
                        System.out.println(turtleName + " Happiness increased "
                                + "by 5 :)");
                        location = "Swimming around the tank";
                        turtleHappiness = turtleHappiness + 5;
                        loopBreak = true;
                        counter++;
                        break;
                    case 1, 4, 7:
                        System.out.println(turtleName + " is sitting on top of"
                                + " the king's rock");
                        location = "Sitting on the king's rock";
                        loopBreak = true;
                        counter++;
                      break;
                    case 2, 5, 8:
                        System.out.println(turtleName + " is hiding under the "
                                + "rocks, looks like he is tired");
                        location = "under the rocks";
                        loopBreak = true;
                        counter++;
                        break;
                    case 9: 
                        break;
                    default:
                        resetCounter();
            }//end switch
        }//end loop
    }//end getLocation
    
    public void getIsHungry() {
        while (loopBreak == false) {
          switch (counter) {
                    case 0, 1, 2:
                        System.out.println(turtleName + " seems content and not"
                                + " hungry");
                        System.out.println(turtleName + " Happiness increased "
                                + "by 10 :)");
                        turtleHappiness = turtleHappiness + 10;
                        isHungry = 0;
                        loopBreak = true;
                        counter++;
                        break;
                    case 3, 4, 5:
                        System.out.println(turtleName + " looks a little "
                                + "hungry");
                        isHungry = 1;
                        loopBreak = true;
                        counter++;
                        break;
                    case 6, 7, 8:
                    System.out.println(turtleName + " is famished, looks "
                            + "like you neglected him :(");
                    System.out.println(turtleName + " Happiness decreased "
                                + "by 50 :(");
                        isHungry = 2;
                        turtleHappiness = turtleHappiness - 50;
                        loopBreak = true;
                        counter++;
                        break;
                    default:
                        System.out.println(turtleName + " needs food NOW or he "
                                + "might die :(");
                        System.out.println(turtleName + " Happiness decreased "
                                + "by 100 :(");
                        turtleHappiness = turtleHappiness - 100;
                        isHungry = 5;
            }//end switch
        }//end loop
    }//end getIsHungry
    
    public int feedTurtle() {
        switch (isHungry) {
            case 0:
                System.out.println("You throw in a portion of turtle food,");
                System.out.println("You realize that " + turtleName + 
                        " is not hungry and the food goes to waste");
                foodSupply = foodSupply - 1;
                break;
            case 1:
                System.out.println(turtleName + " eats 2 portions of food");
                getFoodSupply(2);
                isHungry = 0;
                break;
            case 2:
                System.out.println(turtleName + " is famished and demands "
                        + "a lot of food");
                getFoodSupply(foodSupply / 2);
                isHungry = 0;
                break;
            default:
                System.out.println("in a panic you throw in all of your "
                        + "food supply");
                getFoodSupply(foodSupply);
                resetCounter();
        }//end switch
        counter++;
        return foodSupply;
    }//end feedTurtle
    
    public int getFoodSupply(int foodConsumed) {
        //only call this method when Turtle is fed
        
        if (foodSupply <= 0) {
            System.out.println("No more food supply left...");
            System.out.println("Would you like to add something "
                    + "to you shopping cart?");
            System.out.println("Type 1 for YES and 2 for NO");
            int answer = userInput.nextInt();
            if (answer == 1) {
                System.out.println("How many portions of turtle food do you "
                        + "want added to the shopping cart?");
                int turtleFood = userInput.nextInt();
                System.out.println(turtleFood + " portions of turtle food has "
                        + "been added to your shopping cart!");
                System.out.println(turtleName + " Happiness increased "
                                + "by 25 :)");
                foodSupply = foodSupply + turtleFood;
                turtleHappiness = turtleHappiness + 25;
                
            } else {
                System.out.println(turtleName + " stares at you slightly "
                        + "in disgust");
                System.out.println(turtleName + " Happiness decreased "
                                + "by 100 >:(");
                turtleHappiness = turtleHappiness - 100;
            }//end nested if
        } else {
            System.out.println(turtleName + " eats " + foodConsumed + " portions "
                    + "of turtle food and is satisfied with the meal :)");
            System.out.println(turtleName + " Happiness increased "
                                + "by 50 :)");
            foodSupply = foodSupply - foodConsumed;
            turtleHappiness = turtleHappiness + 50; 
        }//end if
        counter++;
        return foodSupply;
    }//end getFoodSupply
    
    public void setFoodSupply() {
        System.out.println("Enter how many food portions you have in stock");
        foodSupply = userInput.nextInt();
    }//end foodSupply
    
    public int outputFoodSupply() {
        counter++;
        return foodSupply;
    }//end outputFoodSupply
    
    public void statusReport() {
        loopBreak = false;
        System.out.println("********** Status report **********");
        System.out.println(turtleName + " Location: " + location);
        switch (isHungry) {
            case 0:
                System.out.println("Hunger Status: Not hungry");
                break;
            case 1:
                System.out.println("Hunger Status: Slightly hungry");
                break;
            default:
                System.out.println("Hunger Status: Famished");
        }//end switch
        System.out.println("Food supply: " + foodSupply);
        System.out.println(turtleName + " Happiness: " + turtleHappiness);
        System.out.println("***********************************");
        }//end statusReport

    public boolean checkIfDead(){
        if (counter == 9) {
            System.out.println(turtleName + " has starved to death :(");
            System.out.println("************ GAME OVER ************");
            isDead = true;
        } else if (turtleHappiness <= -100) {
            System.out.println(turtleName + " is very sad and stopped "
                    + "eating :(");
            isDead = true;
        } else {
        System.out.println(turtleName + " is doing great! :)");
        }//end if
        return isDead;
    }//end checkIfDead

    public int resetCounter() {
        counter = 0;
        return counter;
    }//end resetCounter
}//end class

