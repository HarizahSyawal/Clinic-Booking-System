/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhammadnaif
 */

package app.com.tutorial;


import java.util.Scanner;


public class Main {

    private static Scanner in;
     private static Scanner inLine;
    private static String user;

     public static void setStaffID(String u){
        user = u;
    }

    public static String getID(){
        return user;
    }
    
    public static void setUsername(String u){
        user = u;
    }

    public static String getUsername(){
        return user;
    }

    public static void main(String[] args)  {        
        inLine = new Scanner(System.in);        

        boolean isCont = false;
        while (!isCont) {
            in = new Scanner(System.in);

            System.out.println("================================================");
            System.out.println("\n\tWelcome To Veterinary Clinic System");
            System.out.println("-------------------------------------");
            System.out.println("[A] Staff");
            System.out.println("[B] Customer");
            System.out.println("================================================");

            System.out.println();
            System.out.print("Enter Choice           : ");                        
            String opt = in.next();            
            
            if (opt.toUpperCase().charAt(0) == 'A') {
                StaffMain.staff();
            } else if (opt.toUpperCase().charAt(0) == 'B') {
                CustomerMain.customer();
            } else {
                System.out.println("Invalid Key!");
                isCont = false;                
            }                        
        }
    }
}     
   
        
             
        


