package javaFullCourse.Lecture28;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args){
        DynamicArray list = new DynamicArray(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
    }
}
class DynamicArray{

    private int[] arr;
    private int size;
    DynamicArray(int capacity){
        arr = new int[capacity];
        size = 0;
    }
    public void add(int element){
        if(size == arr.length){
            resize();
        }
        arr[size] = element;
        size++;
    }
    public void resize(){
        int newArr[] = new int[arr.length*2];
        // now we have to copy elements of old array
        for(int i = 0 ; i<arr.length ; i++){
            // below the old array now point to the new array object build in the memory
            newArr[i] = arr[i];
        }
        //old array now point to the new array
        arr = newArr;

    }
    public void print(){
        for (int i = 0; i< size;i++){
            // that is why we used the old arr here
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
