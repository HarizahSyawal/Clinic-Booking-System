/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.com.tutorial;

import java.util.List;

/**
 *
 * @author Lee
 */
public class WorkingTime {
    private int time;
    List<Doctor> doctor;
    
    public WorkingTime(int t,List<Doctor> d){
        time = t;
        doctor = d;
    }
    
    public int getWorkingTime(){
        return time;
    }
       
    public List<Doctor> getDoctor(){
        return doctor;
    }
}
