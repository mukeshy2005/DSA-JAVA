package javaFullCourse.Lecture32;

public class Students implements Comparable<Students>  {
    private String name;
    private int age;
    private int weight;
    Students(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    // creatign getter or setter
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public int getWeight(){
        return this.weight;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setWeight(int weight){
        this.weight = weight;

    }
    @Override
    public String toString(){
        return this.name +" " + this.age + " " + this.weight;
    }

    @Override
    public int compareTo(Students that) {
        /*we will define our sorting logic here
        * sorting on the basis of the age*/
        if(this.age == that.age){
            return this.name.compareTo(that.name);
        }

        return this.age -that.age;

    }
}
