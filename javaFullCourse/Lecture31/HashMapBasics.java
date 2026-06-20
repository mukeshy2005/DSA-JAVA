package javaFullCourse.Lecture31;

import java.util.*;

public class HashMapBasics {
    public static void main(String [ ] args){
        Map<String, String> mapping = new LinkedHashMap<>();
        mapping.put("in", "india");
//        mapping.put("in ", "china");// this will not insert a new entry only update the value of the key in
        mapping.put("us ", "united states");
        mapping.put("eu", "europe");
        System.out.println(mapping);


        Map<String,String> table = new HashMap<>();
        table.put("en","england");
        table.put("fr","france");

        table.putAll(mapping);
        System.out.println(table);

        table.remove("en");
        System.out.println(table);

        table.size();
        System.out.println(table);
        System.out.println(table.get("fr"));

        //getordefalault
        System.out.println(table.getOrDefault("gk","good kite"));
        System.out.println(table);

        table.replace("in","bharat");
        System.out.println(table);

        Set<String> st = table.keySet();
        System.out.println(st);

        Collection<String> list = table.values();
        System.out.println(list);

        Set<Map.Entry<String,String>>entryofset= table.entrySet();
        System.out.println(entryofset);

        table.computeIfAbsent("fk",k->"india");
        System.out.println(table);

    }
}
