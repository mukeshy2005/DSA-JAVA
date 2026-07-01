//package javaFullCourse.Lecture23;
//
//public class Demo3 {
//    public static void main(String []args){
////        Direction d = new NorhtDirection();
////        d.move();
////        Direction d2 = new NorhtDirection(){
////            @Override
////            public void move() {
////                // this is anonymous class
////                System.out.println("override a method")method;
////            }
////        };
////        d2.move();
//        Direction d =  Direction.NORTH; // WE cannot use new keyword with enum
//        d.move();
//    }
//}
//enum Direction{
//    /*these are object below*/
//    NORTH(){
//        @Override
//        public void move(){
//            System.out.println("move y+1");
//        }
//
//    },EAST(){
//        @Override
//        public void move(
//        ){
//            System.out.println("x -1");
//        }
//    },SOUTH(){
//        @Override
//        public void move(){
//            System.out.println("move y-1");
//        }
//    },WEST(){
//        @Override
//        public void move(){
//            System.out.println("x+1");
//        }
//    };
//    public abstract void move();
//
//}
//// let create a manual abstraction class Polymorphism
////abstract class Direction {
////    public abstract void move();
////}
////class NorhtDirection extends Direction{
////    public  void move(){
////        System.out.println("move to north (y+1)");
////    }
////}
////class SouthDirection extends Direction{
////    public  void move(){
////        System.out.println("move to south (y-1)");
////    }
////}
////class WestDirection extends Direction{
////    public  void move(){
////        System.out.println("move to west (x-1)");
////    }
////}
////class EastDirection extends Direction{
////    public  void move(){
////        System.out.println("move to east (x+1)");
////    }
////}
