package com.lviv.pedigree;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tree {
//    public LocalDate getDate(String dateParse) {
////        LocalDateTime dateTime = LocalDateTime.now();
////        return "format: " + dateTime.format(DateTimeFormatter.ofPattern(format));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        //  formatter = formatter.withLocale( putAppropriateLocaleHere );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
//        LocalDate date = LocalDate.parse(dateParse, formatter);
//        return date;
//    }

    //String positionInLife, String firstName, String lastName, LocalDate dateOfBirth, String cityOfBirth, LocalDate dateOfWedding, String cityOfLiving, String profession, int age, String sex, boolean isLive
//    public void getAllTree() {
//        Map<Person, List<Person>> map1 = new LinkedHashMap<>();
//        List<Person> list = new ArrayList<>();
//        Person me = new Person("My Tree", "Vova", "Js", getDate("1985-07-03"), "Kuiv", getDate("2014-02-02"), "Lviv", "developer", 29, "male", true);
//        Person mom = new Person("My Mom", "Mia", "Js", getDate("1963-04-03"), "Kuiv", getDate("1990-03-02"), "Lviv", "translator", 53, "female", true);
//        list.add(mom);
//        Person dad = new Person("My Dad", "Luck", "Js", getDate("1961-04-07"), "Kuiv", getDate("1990-03-02"), "Lviv", "director", 55, "male", true);
//        list.add(dad);
//        map1.put(me, list);
//        list.clear();
//        Person grandMotherByMom = new Person("My grandMotherByMom", "Lisa", "C++", getDate("1941-04-07"), "Kuiv", getDate("1961-03-02"), "Lviv", "architektor", 75, "female", true);
//        list.add(grandMotherByMom);
//        Person grandFatherByMom = new Person("My grandFatherByMom", "Rock", "C++", getDate("1941-07-07"), "Charkiv", getDate("1961-03-02"), "Lviv", "architektor", 75, "male", true);
//        list.add(grandFatherByMom);
//        map1.put(mom, list);
//        list.clear();
//        Person grandMotherByDad = new Person("My grandMotherByDad", "Louisa", "C#", getDate("1945-04-07"), "Kuiv", getDate("1965-03-04"), "Lviv", "actor", 75, "female", true);
//        list.add(grandMotherByDad);
//        Person grandFatherByDad = new Person("My grandFatherByDad", "Linel", "Js", getDate("1945-01-07"), "Kuiv", getDate("1965-03-04"), "Lviv", "police", 75, "male", true);
//        list.add(grandFatherByDad);
//        map1.put(dad, list);
//        list.clear();
//        Map<Person, List<Person>> map2 = new LinkedHashMap<>();
//        List<Person> list2 = new ArrayList<>();
//        Person me2 = new Person("My Tree", "Luck", "Angular", getDate("1987-07-03"), "Kuiv", getDate("2014-02-02"), "Lviv", "developer", 31, "male", true);
//        Person mom2 = new Person("My Mom", "MiaLia", "Angular", getDate("1963-12-03"), "Kuiv", getDate("1992-03-02"), "Lviv", "doctor", 53, "female", true);
//        list.add(mom2);
//        Person dad2 = new Person("My Dad", "Luck", "Angular", getDate("1961-04-07"), "Kuiv", getDate("1992-03-02"), "Lviv", "director", 55, "male", true);
//        list.add(dad2);
//        map2.put(me2, list);
//        list.clear();
//        Person grandMotherByMom2 = new Person("My grandMotherByMom", "Lina", "C++", getDate("1943-04-07"), "Kuiv", getDate("1965-03-02"), "Lviv", "doctor", 73, "female", true);
//        list.add(grandMotherByMom2);
//        Person grandFatherByMom2 = new Person("My grandFatherByMom", "Lou", "C++", getDate("1943-07-07"), "Charkiv", getDate("1965-03-02"), "Lviv", "architektor", 73, "male", true);
//        list.add(grandFatherByMom2);
//        map2.put(mom2, list);
//        list.clear();
//        Person grandMotherByDad2 = new Person("My grandMotherByDad", "Louisa", "C#", getDate("1945-04-07"), "Kuiv", getDate("1965-03-04"), "Lviv", "actor", 75, "female", true);
//        list.add(grandMotherByDad2);
//        Person grandFatherByDad2 = new Person("My grandFatherByDad", "Linelas", "Angular", getDate("1945-01-07"), "Charkiv", getDate("1965-03-04"), "Lviv", "doctor", 75, "male", true);
//        list.add(grandFatherByDad2);
//        map2.put(dad2, list);
//        list.clear();
//        Map<Person, List<Person>> map3 = new LinkedHashMap<>();
//        List<Person> list3 = new ArrayList<>();
//        Person me3 = new Person("My Tree", "Luck", "NodeJs", getDate("1983-07-03"), "Kuiv", getDate("2014-02-02"), "Lviv", "developer", 33, "male", true);
//        Person mom3 = new Person("My Mom", "Lia", "NodeJs", getDate("1963-11-03"), "Kuiv", getDate("1995-03-02"), "Lviv", "doctor", 53, "female", true);
//        list.add(mom3);
//        Person dad3 = new Person("My Dad", "Lyckus", "NodeJs", getDate("1961-04-07"), "Kuiv", getDate("1995-03-02"), "Lviv", "director", 55, "male", true);
//        list.add(dad3);
//        map3.put(me3, list);
//        list.clear();
//        Person grandMotherByMom3 = new Person("My grandMotherByMom", "Paul", "Angular", getDate("1943-04-07"), "Kuiv", getDate("1965-03-02"), "Lviv", "doctor", 73, "female", true);
//        list.add(grandMotherByMom3);
//        Person grandFatherByMom3 = new Person("My grandFatherByMom", "Lou", "C++", getDate("1943-07-07"), "Charkiv", getDate("1965-03-02"), "Lviv", "architektor", 73, "male", true);
//        list.add(grandFatherByMom3);
//        map3.put(mom3, list);
//        list.clear();
//        Person grandMotherByDad3 = new Person("My grandMotherByDad", "Louisa", "C#", getDate("1945-04-07"), "Kuiv", getDate("1965-03-04"), "Lviv", "actor", 75, "female", false);
//        list.add(grandMotherByDad3);
//        Person grandFatherByDad3 = new Person("My grandFatherByDad", "Paul", "NodeJs", getDate("1945-01-07"), "Charkiv", getDate("1965-03-04"), "Lviv", "doctor", 75, "male", true);
//        list.add(grandFatherByDad3);
//        map3.put(dad3, list);
//        list.clear();
//    }
}
