/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.com.tutorial;

/**
 *
 * @author ASUS
 */
public class Doctor{
    String doctor;
    
    public Doctor(){};
    public Doctor (String doc){
        doctor = doc;
    }
    
    public void setDoctor(String doctor){
        this.doctor = doctor;
    }
 
    public String getDoctor(){return doctor;}
   
}
