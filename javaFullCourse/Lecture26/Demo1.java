package javaFullCourse.Lecture26;

public class Demo1 {
    public static void main(String[] args) {
//        Box b = new Box(10);
//        System.out.println(b.getValue());
//        Box2 b2 = new Box2("hello");
//        System.out.println(b2.getValue());
//        Box b = new Box("hello");
//        Box b2 = new Box(10);
//        Box b3 = new Box(10.4f);// by default decimal value is double we need to force it to float use " f "
//        Box b4 = new Box(true);
//        Box b5 = new Box('a');
//        System.out.println(b.getValue());
//        System.out.println((int)b2.getValue()+10);// <--we have to do here DownCasting to get ride of the error --> will show an error as Object class does not have fixed data type
        /*one more way to do downcasting*/
//        String s = (String)b.getValue();
//        Float f = (Float)b3.getValue();
//        Boolean bool =  (Boolean)b4.getValue();
//        char c = (char)b5.getValue();
//        /*now i can perform the operation on the object class object */
//        System.out.println(b3.getValue());
//        System.out.println(b4.getValue());
//        System.out.println(b5.getValue());


    }
}
//
//class Box{
//    private int  value ;
//    //creating constructor
//    Box(int value){
//        this.value= value;
//    }
//    //making getters and setters
//    public int getValue(){
//        return value;
//    }
//    public void setValue(int value){
//        this.value= value;
//    }
//}
///*do i have to create a new class everytime */
//class Box2 {
//    private String value;
//    Box2(String value){
//        this.value= value;
//    }
//    public String getValue(){
//        return value;
//    }
//    public void setValue(String value){
//        this.value= value;
//    }
//}

//class Box{
//    private Object value;
//    public Box(Object value){
//        this.value = value;
//    }
//    public Object getValue(){
//        return value;
//    }
//    public void setValue(Object value){
//        this.value = value;
//    }
//}