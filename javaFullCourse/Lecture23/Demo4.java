package javaFullCourse.Lecture23;
/*
* enum has 4 fucntions
* 1.values() --> return an array of enum
* 2.valuesof() --> conevert a string into enum constant
* 3. name()--> exact name ko nikal kar lata hai --> toString can also be used at this place
* notes but name method cannot be override
* 4.odinal -->print index of that constant of enum */
public class Demo4 {
    public static void main(String[] args) {
        //method 1 values
//        Direction[] directions = Direction.values();
//        //using a for each loop
//        for(Direction d : directions){
//            System.out.println(d.name());
//            /*as a output we receive all the constant of enum mainly print it */
//        }

        /*method 2 --> valueof()*/
//        Direction d = Direction.NORTH;
//        System.out.println(d);
        Direction direction = Direction.valueOf("SOUTH");
        System.out.println(direction.name());
        System.out.println(direction.ordinal());
        /*
        * If it finds a match: It returns a reference to that existing object.

If it does NOT find a match: It throws a massive runtime error called an IllegalArgumentException.*/
    }
}
enum Direction {
    /*enum under se bydefault enum class ko extends karta hai to further exrend nahi kar sakte
    * per multiple interfaces ko implements kar sakte hai
    * we can Override */
    NORTH, EAST, SOUTH, WEST;
}