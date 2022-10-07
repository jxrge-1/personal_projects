/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking101;

import java.util.Scanner;

/**
 *
 * @author jorgegutierrezjr.
 */
public class Account {
    /*
    ATTEMPT TO IMPLEMENT TRY CATCH FOR SOME USE CASES
    */
    
    
    //local variables
    //balance describes the amount in the account
    //previousTrasaction describes the type of transaction that happend prior
    int balance, lastTransaction;
    String cname, cid;

    //class constructor 
    Account(String cname, String cid) {
        this.cname = cname;
        this.cid = cid;
    }

    //method to deposit money into account
    void deposit(int amount) {
        if (amount > 0) {
            balance += amount; //we get the current value of balance and add it to amount.
            lastTransaction = amount;
            //we set the last transaction amount to the lastest transaction and each trans. overrides the last
        } else {
            System.out.println("Please enter a value greater than 0. Otherwise"
                    + " the account remains the same.");
        }
        System.out.println("You have succesfully deposited $" + amount + "!");
        System.out.println("-------------------------------------------------");
    } //end of deposit method

    //method to withdraw money from account
    void withdraw(int amount) {
        if (amount > 0) {
            balance -= amount;
            lastTransaction = -amount;
            /*since it describes the last transaction, for witahdrawal
            we want to get the negative amount, since we took the # away
             */
        }
        System.out.println("You have successfully withdrew $" + amount + "!");
        System.out.println("-------------------------------------------------");

    }

    void getLastTransaction() {
        if (lastTransaction > 0) {
            System.out.println("You have deposited: $" + lastTransaction + ".");
        } else if (lastTransaction < 0) {
            System.out.println("You have withdrawn $" + lastTransaction + ".");
        } else {
            System.out.println("There were no recent transaction. Trying making one!");
        }
    }

    void accuredInterest(int years) {
        double rate = 0.0185;
        double newBalance = (balance * rate * years) + balance;
        System.out.println("The current interest rate is " + String.format("%.2f", (100 * rate)) + "%");

        if (years == 1) {
            System.out.println("Given the interest rate, after " + years + " year,"
                    + " your new balance will be approximately $" + String.format("%.2f", newBalance) + ".");
        } else {
            System.out.println("Given the interest rate, after " + years + " years,"
                    + " your new balance will be approximately $" + String.format("%.2f", newBalance) + ".");
        }
    }

    void mainMenu() {
        char option = '\0'; //placeholder variable dont look into it
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome back, " + cname + "!\n"
                + "Your Account personal ID is " + cid + ".");

        System.out.println("Select an option...");
        System.out.println("A: Check balance..");
        System.out.println("B: Deposit into account..");
        System.out.println("C: Withdraw from account..");
        System.out.println("D: View last transaction..");
        System.out.println("E: View interest..");
        System.out.println("F: Exit Program...");

        do {
            System.out.println("");
            System.out.println("Enter an Option:\n..enter M to show menu again..");
            char opt1 = scan.next().charAt(0); //scan object is only getting the first letter of the input the user puts
            option = Character.toUpperCase(opt1);
            //option variable is declared at the start of this (mainMenu) method which changes the character into capital
            switch (option) {
                //allows the user to check the balance
                case 'A':
                    System.out.println("**********************************************");
                    System.out.println("Your Current Balance: $" + balance);
                    System.out.println("**********************************************");
                    break;
                case 'B':
                    //case will be if the user wishes to deposit money into their account
                    System.out.println("**********************************************");
                    System.out.println("Input the amount you would like to deposit...");
                    System.out.println("**********************************************");
                    int toDeposit = scan.nextInt();
                    deposit(toDeposit);
                    System.out.println();
                    break;
                case 'C':
                    //case C allows user to withdraw money from the account
                    System.out.println("**********************************************");
                    System.out.println("Input the amount you would like to withdraw...");
                    System.out.println("**********************************************");
                    int toWithdraw = scan.nextInt();
                    withdraw(toWithdraw);
                    break;
                case 'D':
                    //case D allows the user to view the last transaction made
                    System.out.println("**********************************************");
                    getLastTransaction();
                    System.out.println("**********************************************\n");
                    break;
                case 'E': //case E calls the method to see how many years of interest have been accured
                    System.out.println("Enter how many years interest will be accured...");
                    int years = scan.nextInt();
                    accuredInterest(years);
                    break;
                case 'F':
                    //exits the program on command
                    System.out.println("*********************************************");
                    break;
                case 'M':
                    System.out.println("""
                                       \nA: Check balance..
                                       B: Deposit into account..
                                       C: Withdraw from account..
                                       D: View last transaction..
                                       E: View interest..
                                       F: Exit Program..""");
                    break;
                default:
                    System.out.println("Invalid Reponse.. Please enter the following options: A, B, C, D, E, M, F.\n");
                    break;
            }

        } while (option != 'F'); //while userInput is not 'F', it will continue to loop
        System.out.println("Thank You " + cname + " For Banking With Us!\n");
    }
}
