package app.com.tutorial;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class CustomerMain{
    private static Scanner in;    
    
    public static void customer() {
        in = new Scanner(System.in);
        System.out.println("\n\tCustomer Login");
        System.out.println("-------------------------------------");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        
        System.out.println();
        System.out.print("Enter Choice           : ");
        int opt = in.nextInt();
    
        switch (opt) {
            case 1 : custLogin();
                        break;
            case 2 : custRegistration();
                        break;
            default :  System.out.println("Invalid Key!");
                        customer();
        }
    }//end of customer
    
    //custLogin  
    public static void custLogin() {
        String username, password,line;
                
        System.out.println("\t=============[ LOGIN ]============");
        System.out.println("\t__________________________________");
        System.out.println();
        System.out.println("\tUsername: ");
        username = in.next();
        System.out.println("\tPassword: ");
        password = in.next();
    
        try{
            BufferedReader br = new BufferedReader(new FileReader("custlog.txt"));              
            boolean valid = false;
            
            while ((line = br.readLine()) != null) {
                if (line.contains(username) && line.contains(password) ){   
                    valid = true;
                    Main.setUsername(username);
                    customerMenu();
                }               
            }
            
            if(valid == false){
                System.out.println("Wrong Password");
            }
            
            br.close();
        }
        catch(IOException ex)
        {
            System.out.println("File Not Found");
        }
            
    }//end of custLogin  
    
    //custRegistration  
    public static void custRegistration() {
        try {            
            Scanner scan = new Scanner(System.in);
            File cust = new File("customer.txt");  
            File custlog = new File("custLog.txt"); 
            BufferedWriter custbw = new BufferedWriter(new FileWriter("customer.txt",true));
            BufferedWriter logbw = new BufferedWriter(new FileWriter("custLog.txt",true));
            Customer customer = new Customer();
                        
            if(cust.createNewFile()){}else{custbw.newLine();} 
            if(custlog.createNewFile()){}else{logbw.newLine();}
            
            System.out.println("Enter your user name: ");
            customer.setUsername(scan.nextLine());
            System.out.println("Enter your password: ");            
            customer.setPassword(scan.nextLine());
            System.out.println("Enter your full name: ");            
            customer.setFullname(scan.nextLine());    
            System.out.println("Enter your email: ");            
            customer.setEmail(scan.nextLine());
            System.out.println("Enter your phone number: ");            
            customer.setPhone(Integer.parseInt(scan.nextLine()));
            System.out.println("Enter your address: ");            
            customer.setAddress(scan.nextLine());                                    
            
            custbw.write(customer.getUsername()+"\t"+customer.getPassword()+"\t"+customer.getFullName()+"\t"+customer.getEmail()+"\t"+customer.getPhone()+"\t"+customer.getAddress()+"\t");   
            logbw.write(customer.getUsername()+"\t"+customer.getPassword());            
            custbw.close();           
            logbw.close();
            System.out.println("\nSuccessfully wrote to the file.\n");        
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }        
    }//end of custRegistration 
    
    public static void customerMenu() throws IOException{
        System.out.println("\n\tMenu");
        System.out.println("-------------------------------------");
        System.out.println("[0] Clinic Open Time");
        System.out.println("[1] View Appointment");
        System.out.println("[2] Add New Appointment");
        System.out.println("[3] View Profile");
        System.out.println("[4] Add New Pet");
        
        System.out.println();
        System.out.print("Enter Choice           : ");
        int opt = in.nextInt();
    
        switch (opt) {
            case 0   :  clinicTime();
                        break;
            case 1   :  viewAppointment();
                        break;
            case 2   :  addAppointment();
                        break;
            case 3   :  viewProfile();
                        break;
            case 4    : addPet();
                        break;
            default  :  System.out.println("Invalid Key!");
                        StaffMain.staff();
        }
    }//end of customerMenu   
    
    //clinicTime
    public static void clinicTime(){                
        Doctor doc1 = new Doctor("Dr. Rani");
        Doctor doc2 = new Doctor("Dr. Wan");
                
        List<Doctor> doctor1000 = new ArrayList<Doctor>(Arrays.asList(doc1,doc1,doc1,doc2,doc2,doc2));        
        List<Doctor> doctor1200 = new ArrayList<Doctor>(Arrays.asList(doc1,doc1,doc1,doc2,doc2,doc2));        
        List<Doctor> doctor1400 = new ArrayList<Doctor>(Arrays.asList(doc1,doc1,doc1,doc2,doc2,doc2));        
        List<Doctor> doctor1600 = new ArrayList<Doctor>(Arrays.asList(doc2,doc2,doc2,doc1,doc1,doc1));        
        List<Doctor> doctor1800 = new ArrayList<Doctor>(Arrays.asList(doc2,doc2,doc2,doc2,doc1,doc1));        
        List<Doctor> doctor2000 = new ArrayList<Doctor>(Arrays.asList(doc2,doc2,doc2,doc2,doc1,doc1));        
        List<Doctor> doctor2200 = new ArrayList<Doctor>(Arrays.asList(doc2,doc2,doc2,doc2,doc1,doc1));        
        List<WorkingTime> time = new ArrayList<WorkingTime>(Arrays.asList(new WorkingTime(1000,doctor1000),new WorkingTime(1200,doctor1200),new WorkingTime(1400,doctor1400),new WorkingTime(1600,doctor1600),new WorkingTime(1800,doctor1800),new WorkingTime(2000,doctor2000),new WorkingTime(2200,doctor2200)));
                       
        System.out.println("\t\tClinic Timetable");
        System.out.println("\t\t________________");
        System.out.println();
        System.out.println("Day \t |Sunday\t |Monday\t |Tuesday\t |Wednesday\t |Thursday\t |Friday\t |Saturday");
        System.out.println("\n-------------------------------------------------------------");        
        
        for(int i=0;i<time.size();i++){                        
            String line = "";
            
            for(int j=0;j<time.get(i).getDoctor().size();j++){
                if(j != (time.get(i).getDoctor().size()-1)){line += time.get(i).getDoctor().get(j).getDoctor() + "\t |";}  
                else{line += time.get(i).getDoctor().get(j).getDoctor();}
            }
            
            System.out.println(time.get(i).getWorkingTime()+"\t |Close \t |"+line);
        }        
    }//end of clinicTime
    
    
    //viewProfile
    public static void viewProfile() throws IOException {        
        try {            
            Scanner myReader = new Scanner(new File("customer.txt"));                
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] text = data.split("\t");                                
    
                if(data.contains(Main.getUsername())){   
                    String pwd = "";
                    for(int i=0;i<text[1].length();i++){pwd += "*";}
                                        
                    String line2,petName = "invalid";               
                    BufferedReader br = new BufferedReader(new FileReader("pet.txt"));                          
                    Pet pet = null;
                    
                    while ((line2 = br.readLine()) != null) {
                        if (line2.contains(Main.getUsername())){                         
                            String[] text2 = line2.split("\t");                              
                            
                            if(text2[3].equals("Cat")){
                                pet = new Cat(text2[0], Integer.parseInt(text2[1]), text2[2], text2[3]);
                            }
                            else if(text2[3].equals("Dog")){
                                pet = new Dog(text2[0], Integer.parseInt(text2[1]), text2[2], text2[3]);
                            }
                            else if (text2[3].equals("Other")){
                                pet = new Other(text2[0], Integer.parseInt(text2[1]), text2[2], text2[3]);
                            }                            
                        }               
                    }

                    br.close();
                    
                    Customer customer = new Customer(text[0],text[1],text[2],text[4],Integer.parseInt(text[4]),text[5],pet);                    
    
                    System.out.println("\n\n\tProfile Data\n");
                    System.out.println("User Name\t: "+customer.getUsername());
                    System.out.println("Password\t: "+pwd);
                    System.out.println("Full Name\t: "+customer.getFullName());
                    System.out.println("Email\t\t: "+customer.getEmail());
                    System.out.println("Phone Number\t: 0"+customer.getPhone());
                    System.out.println("Address\t\t: "+customer.getAddress());     
                    
                    if(pet.getVariety().equals("Cat")){
                        System.out.println("Pet Name\t\t: "+((Cat)pet).getName()+"\n");
                    }
                    else if(pet.getVariety().equals("Dog")){
                        System.out.println("Pet Name\t\t: "+((Dog)pet).getName()+"\n");
                    }
                    else if (pet.getVariety().equals("Other")){
                        System.out.println("Pet Name\t\t: "+((Other)pet).getName()+"\n");
                    }                                                         
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
    public static void addAppointment() {
        LineNumberReader reader = null;
        int id = 0;
        Customer customer = new Customer();
        try {            
            Scanner scan = new Scanner(System.in);
            File appointment = new File("appointment.txt");  
            BufferedWriter appbw = new BufferedWriter(new FileWriter("appointment.txt",true));
            BufferedReader appbr = new BufferedReader(new FileReader("appointment.txt"));
            
            if(appointment.createNewFile()){}else{appbw.newLine();} 
            
            reader = new LineNumberReader(new FileReader(new File("appointment.txt")));
            // Read file till the end
            while ((reader.readLine()) != null){
                id = reader.getLineNumber() + 1;
            } 
            
            String line,petVariety = "invalid";   
            String petName = "invalid";  
            BufferedReader br = new BufferedReader(new FileReader("pet.txt"));                          
            
            while ((line = br.readLine()) != null) {
                if (line.contains(Main.getUsername())){                         
                    String[] text = line.split("\t");
                    petVariety = text[3];
                    petName = text[0];
                }               
            }
                             
            br.close();
            
            System.out.println("Appointment ID: " +id);
            System.out.println("Enter Appointment Date (dd/mm/yyyy): ");
            String date = scan.nextLine();
            System.out.println("Enter Appointment Time (exp: 1430): ");
            String time = scan.nextLine();            
            System.out.println("Yours username: "+Main.getUsername());
            String name = Main.getUsername();
            System.out.println("Pet Variety: "+petVariety);
            System.out.println("Pet Name: "+petName);
            String petN = petName;
            System.out.println("Reason of Appointment: ");
            String reason = scan.nextLine();       
            
            appbw.write(id+"\t"+date+"\t"+time+"\t"+name+"\t"+petN+"\t"+reason);           
            appbw.close();           
            System.out.println("\nSuccessfully wrote to the file.\n");        
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//end of addAppointment
    
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
                
                if(data.contains(Main.getUsername())){   
    
                    Appointment appoint = new Appointment(Integer.parseInt(text[0]), text[1], text[2], text[3], text[4]);
                    
                    if(text.length == 6){
                        System.out.println(appoint.getId()+"\t"+appoint.getDateNTime()+"\t\t"+appoint.getOwner()+"\t\t"+appoint.getVariety()+"\t\t"+appoint.getReason()+"\t\t"+text[5]+"\t\t");                                                              
                    }
                    else{
                        System.out.println(appoint.getId()+"\t"+appoint.getDateNTime()+"\t\t"+appoint.getOwner()+"\t\t"+appoint.getVariety()+"\t\t"+appoint.getReason()+"\t\t"+text[5]+"\t\t"+text[6]);                                                            
                    }                    
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
    
    public static void addPet() {
        Scanner scan = new Scanner(System.in);
        
         try {                                     
            File pet = new File("pet.txt");
            BufferedWriter petbw = new BufferedWriter(new FileWriter("pet.txt",true));
                        
            if(pet.createNewFile()){}else{petbw.newLine();}
            
            System.out.println("Please choose yours pet variety: ");
            System.out.println("[1] Cat");
            System.out.println("[2] Dog");
            System.out.println("[3] Others");

            System.out.println();
            System.out.print("Enter Choice           : ");
            int opt = in.nextInt();                        
            
            switch (opt) {
                case 1   :  Cat cat = new Cat();

                            System.out.println("Enter your Pet name: ");
                            cat.setName(scan.nextLine());                            
                            System.out.println("Enter your Pet age: ");            
                            cat.setAge(Integer.parseInt(scan.nextLine()));
                            cat.setOwner(Main.getUsername());
                            cat.setVariety("Cat");                            
                            petbw.write(cat.getName()+"\t"+cat.getAge()+"\t"+cat.getOwner()+"\t"+cat.getVariety());
                            break;

                case 2   :  Dog dog = new Dog();

                            System.out.println("Enter your Pet name: ");
                            dog.setName(scan.nextLine());
                            System.out.println("Enter your Pet age: ");            
                            dog.setAge(Integer.parseInt(scan.nextLine()));
                            dog.setOwner(Main.getUsername());
                            dog.setVariety("Dog");                            
                            petbw.write(dog.getName()+"\t"+dog.getAge()+"\t"+dog.getOwner()+"\t"+dog.getVariety());
                            break;

                case 3   :  Other other = new Other();

                            System.out.println("Enter your Pet name: ");
                            other.setName(scan.nextLine());
                            System.out.println("Enter your Pet age: ");            
                            other.setAge(Integer.parseInt(scan.nextLine()));
                            other.setOwner(Main.getUsername());
                            System.out.println("Enter your Pet variety(exp: Rabbit): ");
                            other.setVariety(scan.nextLine());                            
                            petbw.write(other.getName()+"\t"+other.getAge()+"\t"+other.getOwner()+"\t"+other.getVariety());
                            break;

                default  :  System.out.println("Invalid Key!");
                            StaffMain.staff();
            }
                      
            petbw.close();           
            System.out.println("\nSuccessfully wrote to the file.\n");        
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }    
    }//end of addPet
}