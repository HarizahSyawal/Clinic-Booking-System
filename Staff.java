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


class Staff{
    private String StaffName,StaffEmail,StaffPassword;
    private int StaffID,StaffPhone;
    //constructor
    public Staff(){};
    public Staff(int id,String name,String email,String password,int phone){
        StaffName = name;
        StaffEmail = email;
        StaffPassword = password;
        StaffID = id;
        StaffPhone = phone;
    }
    
    //
    public void setStaffName(String sName){
        StaffName = sName;
    }
    
    public void setStaffEmail(String sEmail){
        StaffEmail = sEmail;
    }
    
    public void setStaffPassword(String sPassword){
        StaffPassword = sPassword;
    }
    
    public void setStaffID(int id){
        StaffID = id;
    }
    
    public void setStaffPhone(int phone){
        StaffPhone = phone;
    }
    
    public String getStaffName(){
        return StaffName;
    }
    
    public String getStaffEmail(){
        return StaffEmail;
    }
    
    public String getStaffPassword(){
        return StaffPassword;
    }
    
    public int getStaffID(){
        return StaffID;
    }
    
    public int getStaffPhone(){
        return StaffPhone;
    }
}
