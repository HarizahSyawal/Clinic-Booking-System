package app.com.tutorial;


public abstract class Pet {
    // private instance variables
    public String owner, variety; 
    
    /** Constructs a Pet */
    public Pet(){};
    public Pet( String owner, String variety) {
       this.owner = owner;
       this.variety = variety;
    }
    
    // Getters and Setters
    /** Returns the owner
     * @param owner */
   public abstract void setOwner(String owner);
   public abstract void setVariety(String variety);
   public abstract String getOwner();
   public abstract String getVariety();
}


