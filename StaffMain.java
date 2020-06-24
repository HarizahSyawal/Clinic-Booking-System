package app.com.tutorial;

import java.io.*;
import java.util.Scanner;

class StaffMain{
    private static Scanner in;

    public static void staff() {
        System.out.print('\u000C');
            in = new Scanner(System.in);
            System.out.println("\n\tStaff Login");
            System.out.println("-------------------------------------");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            
            System.out.println();
            System.out.print("Enter Choice           : ");
            int opt = in.nextInt();
    
            switch (opt) {
                case 1 : staffLogin();
                            break;
                case 2 : staffRegistration();
                            break;
                default :  System.out.println("Invalid Key!");
                            staff();
                }
    }//end of staff    
        
    //staffLogin  
    public static void staffLogin() {
    String password,line;
    String id;
    
        System.out.println("\t=============[ LOGIN ]============");
        System.out.println("\t__________________________________");
        System.out.println();
        System.out.println("\tUsername: ");
        id = in.next();
        System.out.println("\tPassword: ");
        password = in.next();
    
            try{
            BufferedReader br = new BufferedReader(new FileReader("staffLog.txt"));              
            boolean authenticated = false;
            
            while ((line = br.readLine()) != null) {                                     
                String[] text = line.split("\t");

                if (text[0].equals(id) && text[1].equals(password)){                                       
                    authenticated = true;
                    Main.setStaffID(id);
                    staffMenu();                    
                }               
            }

            if(authenticated == false){System.out.println("Wrong Password");} 
            
            br.close();
        }
        catch(IOException ex)
        {
            System.out.println("File Not Found");
        }
            
    }//end of staffLogin  
    
    //staffRegistration  
    public static void staffRegistration() {
      try {            
            Scanner scan = new Scanner(System.in);
            File staff = new File("staff.txt");  
            File custlog = new File("staffLog.txt"); 
            BufferedWriter staffbw = new BufferedWriter(new FileWriter("staff.txt",true));
            BufferedWriter logbw = new BufferedWriter(new FileWriter("staffLog.txt",true));
            Staff st = new Staff();
                        
            if(staff.createNewFile()){}else{staffbw.newLine();} 
                if(custlog.createNewFile()){}else{logbw.newLine();}
            
            System.out.println("Enter your ID: ");
            st.setStaffID(Integer.parseInt(scan.nextLine()));
            System.out.println("Enter your Name: ");            
            st.setStaffName(scan.nextLine());
            System.out.println("Enter your Email: ");            
            st.setStaffEmail(scan.nextLine());    
            System.out.println("Enter your Password: ");            
            st.setStaffPassword(scan.nextLine());
            System.out.println("Enter your phone number: ");            
            st.setStaffPhone(Integer.parseInt(scan.nextLine()));
           
    
            staffbw.write(st.getStaffID()+"\t"+st.getStaffName()+"\t"+st.getStaffEmail()+"\t"+st.getStaffPassword()+"\t"+st.getStaffPhone());   
            logbw.write(st.getStaffID()+"\t"+st.getStaffPassword());            
            staffbw.close();           
            logbw.close();
            System.out.println("\nSuccessfully wrote to the file.\n");        
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }        
    }//end of staffRegistration   
    
    public static void staffMenu(){
        System.out.println("\n\tMenu");
        System.out.println("-------------------------------------");
        System.out.println("[1] View Profile");
        System.out.println("[2] View Appointment");
        System.out.println("[3] Cancel or Approve appointment");
        
        
        System.out.println();
        System.out.print("Enter Choice           : ");
        int opt = in.nextInt();
    
        switch (opt) {
            case 1   :  viewProfile();
                        break;
            case 2   :  viewAppointment();
                        break;
            case 3   :  editAppointment();
                        break;
            default  :  System.out.println("Invalid Key!");
                        StaffMain.staff();
        }
    }//end of staffMenu
    
     public static void viewProfile() {        
        try {            
            Scanner myReader = new Scanner(new File("staff.txt"));
    
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] text = data.split("\t");                                
    
                if(data.contains(Main.getID())){   
                    String pwd = "";
                    for(int i=0;i<text[1].length();i++){pwd += "*";}
                                        
                    Staff staff = new Staff(Integer.parseInt(text[0]),text[1],text[2],text[3],Integer.parseInt(text[4]));                    
    
                    System.out.println("\n\n\tProfile Data\n");
                    System.out.println("ID\t: "+staff.getStaffID());
                    System.out.println("Name\t: "+staff.getStaffName());
                    System.out.println("Email\t\t: "+staff.getStaffEmail());
                    System.out.println("Phone Number\t: 0"+staff.getStaffPhone());
                    System.out.println("Password\t: "+pwd);                
                }                                
            }
            System.out.println("\n\n");
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }      
        
    }//end of viewProfile

      
      //Edit Appointment(Approve or decline)
      public static void editAppointment(){
        try{                                 
            Scanner appoint = new Scanner(new File("appointment.txt"));
            StringBuffer buffer = new StringBuffer();            
            Scanner scan = new Scanner(System.in);    
            int count = 0;          

            while (appoint.hasNextLine()) {                
                String data = appoint.nextLine();                
                String[] text = data.split("\t");                
                
                if(text.length == 6){                                                          
                    System.out.println(data);                     
                    System.out.println("\nApprove/Reject: ");                    
                    String status = scan.next();
                    buffer.append(data+"\t"+status);
                }
                else{
                    buffer.append(data);
                }

                count++;                
                if(count > 0){
                    buffer.append("\n");
                }
            }

            FileOutputStream output = new FileOutputStream("appointment.txt");
            output.write(buffer.toString().getBytes());
            output.close();            
            appoint.close();                        
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//end of editAppointment
      
      
      //viewAppointment
      public static void viewAppointment() {       
        try {            
            Scanner myReader = new Scanner(new File("appointment.txt"));
            
            if(myReader.hasNextLine()){
                System.out.println("\n\nApppointment Data\n");
                System.out.println("ID\tDate\t\t\tTime\t\tOwner\t\tVariety\t\tReason\t\tApproval");
                System.out.println("___________________________________________________________________________________________________________");
            }
            else{
                System.out.println("\n\nNo appointments found.\n");
            }
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] text = data.split("\t");   
                
              
                    Appointment appoint = new Appointment(Integer.parseInt(text[0]), text[1], text[2], text[3], text[4]);
                    
                    if(text.length == 6){
                        System.out.println(appoint.getId()+"\t"+appoint.getDateNTime()+"\t\t"+appoint.getOwner()+"\t\t"+appoint.getVariety()+"\t\t"+appoint.getReason()+"\t\t"+text[5]+"\t\t");                                                              
                    }
                    else{
                        System.out.println(appoint.getId()+"\t"+appoint.getDateNTime()+"\t\t"+appoint.getOwner()+"\t\t"+appoint.getVariety()+"\t\t"+appoint.getReason()+"\t\t"+text[5]+"\t\t"+text[6]);                                                            
                    }                    
                }
            
            System.out.println("\n\n");
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }//end of addAppointment
}    