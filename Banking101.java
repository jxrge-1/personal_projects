/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banking101;

/**
 *
 * @author jorgegutierrezjr.
 */
import java.util.Scanner;

public class Banking101  {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
       // System.out.println("Welcome to Famous Keeb International Bank!\nWhat is your name?");
      //  String myName = scan.nextLine();
        
       

       // System.out.println("One second..");
        
//        Account user = new Account(myName, "A5924116");
        Account user = new Account("Jorge","A1506298");
        user.mainMenu();
        
    }
    
}
