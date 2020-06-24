package app.com.tutorial;


class Customer{
    //Declare attributes of Customer class
    private String username,fullname,email,address,password;
    private int phoneNum;
    private Pet pet;
    
    public Customer(){};

    //Constructor of Customer class
    public Customer(String user,String pwd,String full,String e,int phone,String addr,Pet p){
        username = user;
        password = pwd;
        fullname = full;
        email = e;
        phoneNum = phone;
        address = addr;              
        pet = p;
    }
        
    //Assign value for customer's user name
    public void setUsername(String user){
        username = user;
    }
    
    //Assign value for customer's full name
    public void setFullname(String full){
        fullname = full;
    }
    
    //Assign value for customer's email
    public void setEmail(String e){
        email = e;
    }
    
    //Assign value to phoneNum phone number
    public void setPhone(int phone){
        phoneNum = phone;
    }
    
    //Assign value for customer's address
    public void setAddress(String addr){
        address = addr;
    }

    //Assign value for customer's password
    public void setPassword(String pwd){
        password = pwd;
    }
    
    //Assign value for customer's pet
    public void setPet(Pet p){
        pet = p;
    }

    //Return value of customer's user name
    public String getUsername(){
        return username;
    }
    
    //Return value of customer's full name
    public String getFullName(){
        return fullname;
    }
    
    //Return value of customer's email
    public String getEmail(){
        return email;
    }
    
    //Return value of customer's phone number
    public int getPhone(){
        return phoneNum;
    }
    
    //Return value of customer's address
    public String getAddress(){
        return address;
    }

    //Return value of customer's password
    public String getPassword(){
        return password;
    }
    
    //Return value of customer's pet
    public Pet getPet(){
        return pet;
    }
}