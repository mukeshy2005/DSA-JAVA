package Programs;
class Dog {
 String name;
 void bark(){
  System.out.println( name + " Saya Ruff ");
 }
 void eat(){
     System.out.println("eating right now ");
 }
 void chaseCat(){
     System.out.println("chasing cat");
 }

    public static void main (String[] args){
     Dog Dog1= new Dog();
     Dog1.bark();
     Dog1.name="mukku";

     Dog[] myDogs = new Dog[3];
     myDogs[0]= new Dog();
     myDogs[1]= new Dog();
     myDogs[2]= Dog1;

     myDogs[0].name="topphy";
     myDogs[1].name="dollar";

     System.out.println("Last dOG'S name is ");
     System.out.println(myDogs[2].name);
      int x =0;
     while(x<myDogs.length){
         myDogs[x].bark();
         x=x+1;
     }
    }

}
