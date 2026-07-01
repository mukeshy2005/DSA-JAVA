package javaFullCourse.Lamdas;


import java.util.*;

public class Demo1 {
    static void main() {
       List<Students> list = new ArrayList<Students>();
       list.add( new Students("mukesh",42,95));
       list.add( new Students("vishal",41,93));
       list.add( new Students("nitish",49,94));
       list.add( new Students("manas",43,99));


//       Comparator<Students> c1 = new SortByName();
//       Comparator<Students> c2 = new SortByRollNumber();
//       Comparator<Students> c3 = new SortByMarks();

       Collections.sort(list,(s1,s2)->s1.RollNumber - s2.RollNumber);


       for(Students s : list){
           System.out.println(s.name +","+s.RollNumber+","+s.Mark);
       }
//        for (int i =0; i<list.size();i++){
//            System.out.println( (list.get(i)));
//        }
    }
}
//class SortByName implements Comparator<Students> {
//    @Override
//    public int compare(Students s1, Students s2) {
//        return s1.name.compareTo(s2.name);
//    }
//}
//
//class SortByRollNumber implements Comparator<Students> {
//    @Override
//    public int compare(Students s1, Students s2) {
//        return s1.RollNumber - s2.RollNumber;
//    }
//}
//class SortByMarks implements Comparator<Students> {
//    @Override
//    public int compare(Students s1, Students s2) {
//        return s1.Mark - s2.Mark;
//    }
//}

// we need to implement comparable or comprator
class Students {
    String name;
    int RollNumber;
    int Mark;

    Students(String name, int RollNumber, int Mark){
        this.name = name;
        this.RollNumber = RollNumber;
        this.Mark = Mark;
    }
//    @Override
//    public int compareTo(Student o) {
//        return this.Mark - o.Mark;
//    }
}