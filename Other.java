package app.com.tutorial;

    class Other extends Pet {
       // private instance variables
        public String name;
        public int age;

      /** Constructs Other */
    public Other(){};
    public Other(String name, int age,String var,String own){
        super.owner = own; // invoke superclass' constructor Pet()
        super.variety = var;
        this.name=name;
        this.age=age;

    }

    public void setAge(int age){
      this.age = age;
   }
   public void setName(String name){
      this.name =  name;
   }
    public int getAge(){
       return age;
    }
    public String getName(){
       return name;
    }
    /** Returns the variety */
    public String variety(){
        return variety;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }
    @Override
    public void setVariety(String variety) {
        this.variety = variety;
    }
    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public String getVariety() {
        return variety;
    }
}