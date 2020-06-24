package app.com.tutorial;

public class Appointment {
    private int id;
    private String dateNtime,owner,variety,reason;

    public Appointment(){}

    public Appointment(int i,String d,String o,String v,String r){
        id = i;
        dateNtime = d;
        owner = o;
        variety = v;
        reason = r;
    }

    public void setId(int i){
        id = i;
    }

    public void setDateNTime(String d){
        dateNtime = d;
    }

    public void setOwner(String o){
        owner = o;
    }

    public void setVariety(String v){
        variety = v;
    }

    public void setReason(String r){
        reason = r;
    }

    public int getId(){
        return id;
    }

    public String getDateNTime(){
        return dateNtime;
    }

    public String getOwner(){
        return owner;
    }

    public String getVariety(){
        return variety;
    }

    public String getReason(){
        return reason;
    }
}