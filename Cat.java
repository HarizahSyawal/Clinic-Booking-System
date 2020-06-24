package app.com.tutorial;


class Cat extends Pet{
    String name;
    int age;

         /** Constructs a Cat */
   public Cat(){};
   public Cat(String name, int age, String own, String var){
       super.owner = own;
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