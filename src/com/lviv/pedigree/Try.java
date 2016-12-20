package com.lviv.pedigree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitalik on 22.09.2016.
 */
public class Try {
    public static void main(String[] args) {
        List<Man> menOne = new ArrayList<>();
        Man one = new Man("One", 12);
        Man two = new Man("Two", 13);
        Man three = new Man("Three", 16);
//        menOne.add(one);
        menOne.add(two);
        Map<Man, List<Man>> listMap = new HashMap<>();
        listMap.put(one, menOne);
        List<Man> menTwo = new ArrayList<>();
        menTwo.add(three);
        listMap.put(two, menTwo);
//        three.age = 555;
        menTwo.clear();
        System.out.println(one.name + " : " + one.age);
        listMap.get(one).stream().forEach(elem -> {
            System.out.println(elem.name + " : " + elem.age);
            listMap.get(elem).stream().forEach(elem1 -> {
                System.out.println(elem1.name + " : " + elem1.age);
            });
        });
    }


}

class Man {
    public String name;
    public int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
