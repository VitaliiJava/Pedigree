package com.lviv.pedigree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Pedigree {

    private static final Scanner scanner = new Scanner(System.in);
    private Map<Person, List<Person>> map;

    public Map<Person, List<Person>> getMap() {
        return map;
    }

    public Pedigree() {
        map = new LinkedHashMap<>();
        List<Person> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Person me = new Person(Degree.I, "Vova", "Js", LocalDate.parse("1985-07-03", formatter),
                "Kuiv", LocalDate.parse("2014-02-02", formatter), "Lviv", "developer",

                29, Sex.MALE, true);
        Person mom = new Person(Degree.MOM, "Mia", "Js", LocalDate.parse("1963-04-03", formatter),
                "Kuiv", LocalDate.parse("1990-03-02", formatter), "Lviv", "translator",
                53, Sex.FEMALE, true);
        Person brother = new Person(Degree.BROTHER, "Oleg", "Js", LocalDate.parse("1990-03-03"),
                "Lviv", null, "Lviv", "developer", 26, Sex.MALE, true);
        Person dad = new Person(Degree.DAD, "Luck", "Js", LocalDate.parse("1961-04-07", formatter),
                "Kuiv", LocalDate.parse("1990-03-02", formatter), "Lviv", "director",
                55, Sex.MALE, false);
        Person dad2 = new Person(Degree.DAD, "Luck2", "Js", LocalDate.parse("1961-04-07", formatter),
                "Kuiv", LocalDate.parse("1990-03-02", formatter), "Lviv", "director",
                55, Sex.MALE, false);
        list.add(mom);
        list.add(brother);
        list.add(dad);
        map.put(me, list);
        List<Person> list2 = new ArrayList<>();
        Person grandMotherByMom = new Person(Degree.GRAND_MOTHER_BY_MOM, "Lisa", "C++",
                LocalDate.parse("1941-04-07", formatter), "Kuiv", LocalDate.parse("1961-03-02", formatter),
                "Lviv", "architektor", 75, Sex.FEMALE, true);
        Person son = new Person(Degree.GRAND_MOTHER_BY_MOM_SON, "Igor", "C++",
                LocalDate.parse("1968-03-03", formatter), "Lviv", null, "Lviv",
                "null", 7, Sex.MALE, false);
        Person son2 = new Person(Degree.GRAND_MOTHER_BY_MOM_SON, "Igor2", "C++",
                LocalDate.parse("1968-03-03", formatter), "Lviv", null, "Lviv",
                "null", 7, Sex.MALE, false);
        list2.add(grandMotherByMom);
        Person grandFatherByMom = new Person(Degree.GRAND_FATHER_BY_MOM, "Rock", "C++",
                LocalDate.parse("1941-07-07", formatter), "Charkiv", LocalDate.parse("1961-03-02", formatter),
                "Lviv", "architektor", 75, Sex.MALE, true);
        list2.add(grandFatherByMom);
        map.put(mom, list2);
        List<Person> listS = new ArrayList<>();
        listS.add(son);
        listS.add(son2);
        map.put(grandMotherByMom, listS);
        map.put(son2, Collections.singletonList(dad2));
        List<Person> list3 = new ArrayList<>();
        Person grandMotherByDad = new Person(Degree.GRAND_MOTHER_BY_DAD, "Louisa", "C#",
                LocalDate.parse("1945-04-07", formatter), "Kuiv", LocalDate.parse("1965-03-04", formatter),
                "Lviv", "actor", 75, Sex.FEMALE, false);
        list3.add(grandMotherByDad);
        Person grandFatherByDad = new Person(Degree.GRAND_FATHER_BY_DAD, "Linel", "Js",
                LocalDate.parse("1945-01-07", formatter), "Kuiv", LocalDate.parse("1965-03-04", formatter),
                "Lviv", "police", 75, Sex.MALE, false);
        list3.add(grandFatherByDad);
        map.put(dad, list3);

    }

    public void menu() {
        System.out.println("1) Выводить родословное дерево конкретного человека.");
        System.out.println("2) Показывать прямых родственников.");
        System.out.println("3) Вычислять статистику по всему дереву: количество живых.");
        System.out.println("4) Вычислять статистику по всему дереву: мужчин/женщин.");
        System.out.println("5) Вычислять статистику по всему дереву: среднее количество детей.");
        System.out.println("6) Вычислять статистику по всему дереву: среднюю продолжительность жизни.");
        System.out.println("7) Показывать прямых родственников с братьями и сёстрами, все родственники.");
        System.out.println("8) Показывать степень родства двух людей.");
        System.out.println("9) Create own Tree.");
        System.out.println("10) Exit.");
    }

    public LocalDate getDate(String dateParse) {
        System.out.println(dateParse);
        String date = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, formatter);
        return date1;
    }

    //1) Выводить родословное дерево конкретного человека.
    public void getTreeOfPerson() {
        String firstName = getInfo("Input first name of person");
        String lastName = getInfo("Input last name of person");

        for (Map.Entry<Person, List<Person>> entry : map.entrySet()) {
            Person key = entry.getKey();
            if (key.getFirstName().equalsIgnoreCase(firstName) && key.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(key);
                for (Person person : entry.getValue()) {
                    System.out.println(person + " -> ");
                    loopOnPersons(person);
                    System.out.println("End of tree of " + person.getLastName() + " : " + person.getFirstName());
                }
            }
        }
    }


    private void loopOnPersons(Person person) {
        List<Person> persons = map.get(person);
        if (persons == null) {
            return;
        }
        persons.forEach(System.out::println);
        persons.forEach(this::loopOnPersons);
    }

    //2) Показывать прямых родственников
    public void getFromTreeOnlyNeibors() {
        String firstName = getInfo("Input first name of person");
        String lastName = getInfo("Input last name of person");
        for (Map.Entry<Person, List<Person>> entry : map.entrySet()) {
            Person key = entry.getKey();
            if (key.getFirstName().equalsIgnoreCase(firstName) && key.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(key + " -> " + entry.getValue());// + "\nEnd of " + key);
            }
        }
    }

    //3) Вычислять статистику по всему дереву: количество живых.
    public void getIsLifePersonFromTree() {
        Set<Person> setNew = new HashSet<>();
        Set<Map.Entry<Person, List<Person>>> set = map.entrySet();
        Iterator<Map.Entry<Person, List<Person>>> iter = set.iterator();
        while (iter.hasNext()) {
            Person person = iter.next().getKey();
            if (person.isLive()) {
                System.out.println(person);
            }
            Iterator<Person> listIter = map.get(person).iterator();
            while (listIter.hasNext()) {
                Person nextPerson = listIter.next();
                if (nextPerson.isLive()) {
                    System.out.println(nextPerson);
                }
            }
            if (person.isLive()) {
                System.out.println("End of " + person.getFirstName() + " " + person.getLastName());
            }
        }
    }

    //    4) Вычислять статистику по всему дереву: мужчин/женщин.
    public void getMaleOrFemaleFromTree() {
        String choice = getInfo("Input 1 if you want to see how many men in the tree and 2 for women.");
        if (choice.equals("1")) {
            getMaleFromTree();
        } else if (choice.equals("2")) {
            getFeMaleFromTree();
        }
    }


    public void getMaleFromTree() {
        Set<Map.Entry<Person, List<Person>>> set = map.entrySet();
        Iterator<Map.Entry<Person, List<Person>>> iter = set.iterator();
        while (iter.hasNext()) {
            Person person = iter.next().getKey();
            if (person.getSex().equals(Sex.MALE)) {
                System.out.println(person);
            }
            Iterator<Person> listIter = map.get(person).iterator();
            while (listIter.hasNext()) {
                Person nextPerson = listIter.next();
                if (nextPerson.getSex().equals(Sex.MALE)) {
                    System.out.println(nextPerson);
                }
            }
            if (person.getSex().equals(Sex.MALE)) {
                System.out.println("End of " + person.getFirstName() + " " + person.getLastName());
            }
        }
    }

    public void getFeMaleFromTree() {
        Set<Map.Entry<Person, List<Person>>> set = map.entrySet();
        Iterator<Map.Entry<Person, List<Person>>> iter = set.iterator();
        while (iter.hasNext()) {
            Person person = iter.next().getKey();
            if (person.getSex().equals(Sex.FEMALE)) {
                System.out.println(person);
            }
            Iterator<Person> listIter = map.get(person).iterator();
            while (listIter.hasNext()) {
                Person nextPerson = listIter.next();
                if (nextPerson.getSex().equals(Sex.FEMALE)) {
                    System.out.println(nextPerson);
                }
            }
            if (person.getSex().equals(Sex.FEMALE)) {
                System.out.println("End of " + person.getFirstName() + " " + person.getLastName());
            }
        }
    }

    //5) Вычислять статистику по всему дереву: среднее количество детей.
    public void getAvgOfChildrenFromTree() {
        Set<Map.Entry<Person, List<Person>>> set = map.entrySet();
        Iterator<Map.Entry<Person, List<Person>>> iter = set.iterator();
        while (iter.hasNext()) {
            Person person = iter.next().getKey();
            Degree degree = person.getDegree();
            if (isAChildren(degree)) {
                System.out.println(person);
            }
            Iterator<Person> listIter = map.get(person).iterator();
            while (listIter.hasNext()) {
                Person nextPerson = listIter.next();
                Degree nextPersonDegree = nextPerson.getDegree();
                if (isAChildren(nextPersonDegree)) {
                    System.out.println(nextPerson);
                }
            }
            if (isAChildren(degree)) {
                System.out.println("End of " + person.getFirstName() + " " + person.getLastName());
            }
        }
    }

    private boolean isAChildren(Degree nextPersonDegree) {
        return nextPersonDegree.equals(Degree.BROTHER) ||
                nextPersonDegree.equals(Degree.I) ||
                nextPersonDegree.equals(Degree.SISTER) ||
                nextPersonDegree.equals(Degree.GRAND_MOTHER_BY_MOM_SON);
    }

    //6) Вычислять статистику по всему дереву: среднюю продолжительность жизни.
    public void getAvgOfLongLifeFromTree() {
        int count = 0;
        int countPerson = 0;
        Set<Map.Entry<Person, List<Person>>> set = map.entrySet();
        Iterator<Map.Entry<Person, List<Person>>> iter = set.iterator();
        while (iter.hasNext()) {
            Person person = iter.next().getKey();
            count = count + person.getAge();
            countPerson++;
            Iterator<Person> listIter = map.get(person).iterator();
            while (listIter.hasNext()) {
                Person nextPerson = listIter.next();
                count = count + nextPerson.getAge();
                countPerson++;
            }
            System.out.println("Result of task: " + (count / countPerson));
        }
    }

    //7) Показывать прямых родственников с братьями и сёстрами, все родственники.
    public void getOnlyNeiborsWithBrothersAndSistersOrAllPersonFromTree() {
        Set<Map.Entry<Person, List<Person>>> set = map.entrySet();
        Iterator<Map.Entry<Person, List<Person>>> iter = set.iterator();
        while (iter.hasNext()) {
            Person person = iter.next().getKey();
            if (person.getDegree().equals(Degree.SISTER) || person.getDegree().equals(Degree.BROTHER)) {
                System.out.println(person);
            }
            Iterator<Person> listIter = map.get(person).iterator();
            while (listIter.hasNext()) {
                Person nextPerson = listIter.next();
                if (nextPerson.getDegree().equals(Degree.SISTER) || nextPerson.getDegree().equals(Degree.BROTHER)) {
                    System.out.println(nextPerson);
                }
            }
            if (person.getDegree().equals(Degree.SISTER) || person.getDegree().equals(Degree.BROTHER)) {
                System.out.println("End of " + person.getFirstName() + " " + person.getLastName());
            }
        }
    }

    //8) Показывать степень родства двух людей.
    public void getPositionBetweenTwoPersonsFromTree() {
        String firstName = getInfo("Input first name of 1person");
        String lastName = getInfo("Input last name of 1person");
        String firstName2 = getInfo("Input first name of 2person");
        String lastName2 = getInfo("Input last name of 2person");
        Set<Map.Entry<Person, List<Person>>> set = map.entrySet();
        Iterator<Map.Entry<Person, List<Person>>> iter = set.iterator();
        while (iter.hasNext()) {
            Person person = iter.next().getKey();
            if (person.getFirstName().equalsIgnoreCase(firstName) &&//refactoring
                    person.getLastName().equalsIgnoreCase(lastName)) {
                person.getDegree().printDegreeInSmallLetter();
            }
            if (person.getFirstName().equalsIgnoreCase(firstName2) &&
                    person.getLastName().equalsIgnoreCase(lastName2)) {
                person.getDegree().printDegreeInSmallLetter();
            }

            Iterator<Person> listIter = map.get(person).iterator();
            while (listIter.hasNext()) {
                Person nextPerson = listIter.next();
                if (nextPerson.getFirstName().equalsIgnoreCase(firstName) &&
                        nextPerson.getLastName().equalsIgnoreCase(lastName)) {
                    nextPerson.getDegree().printDegreeInSmallLetter();
                }
                if (nextPerson.getFirstName().equalsIgnoreCase(firstName2) &&
                        nextPerson.getLastName().equalsIgnoreCase(lastName2)) {
                   nextPerson.getDegree().printDegreeInSmallLetter();
                }
            }
        }
    }

    public Person createPerson() {
        Degree positionInLife = Degree.valueOf(getInfo("<< Input info of person please >>\nInput position in life like (mom,dad or smth.else"));
        String firstName = getInfo("Input first name of person");
        String lastName = getInfo("Input last name of person");
        LocalDate dateOfBirth = getDate("Input date of birth of person like(YYYY-MM-DD)");
        String cityOfBirth = getInfo("Input city of birth of person");
        LocalDate dateOfWedding = getDate("Input date of Wedding of person like(YYYY-MM-DD)");
        String cityOfLiving = getInfo("Input city of living of person");
        String profession = getInfo("Input profession of person");
        System.out.println("Input age of person");
        int age = scanner.nextInt();
        Sex sex = Sex.valueOf(getInfo("Input sex of person like(male,female)"));
        System.out.println("Input is person live or not (true or false)");
        boolean isLive = scanner.nextBoolean();
        Person person = new Person(positionInLife, firstName, lastName, dateOfBirth, cityOfBirth, dateOfWedding, cityOfLiving, profession,
                age, sex, isLive);
        return person;

    }

    private String getInfo(String string) {
        System.out.println(string);
        return scanner.next();
    }

    public void createTree() {
        List<Person> list = new ArrayList<>();
        System.out.println("Input person who will in the root of the tree.");
        Person me = createPerson();
        Person mom = createPerson();
        list.add(mom);
        Person dad = createPerson();
        list.add(dad);
        map.put(me, list);
        List<Person> list2 = new ArrayList<>();
        Person grandMotherByMom = createPerson();
        list2.add(grandMotherByMom);
        Person grandFatherByMom = createPerson();
        list2.add(grandFatherByMom);
        map.put(mom, list2);
        List<Person> list3 = new ArrayList<>();
        Person grandMotherByDad = createPerson();
        list3.add(grandMotherByDad);
        Person grandFatherByDad = createPerson();
        list3.add(grandFatherByDad);
        map.put(dad, list3);

        System.out.println("Do you remember your pra-pra parents by mom line?(press 1 'yes' or 2 no");
        int choise = scanner.nextInt();
        if (choise == 1) {
            List<Person> list4 = new ArrayList<>();
            Person grandMotherByMomOld = createPerson();
            list4.add(grandMotherByMomOld);
            Person grandFatherByMomOld = createPerson();
            list4.add(grandFatherByMomOld);
            map.put(grandMotherByMom, list4);
        } else if (choise == 2) {
            System.out.println("Ok!");
        }
        choise = 0;
        System.out.println("Do you remember your pra-pra parents by dad line?(press 1 'yes' or 2 no");
        if (choise == 1) {
            List<Person> list5 = new ArrayList<>();
            Person grandMotherByDadOld = createPerson();
            list5.add(grandMotherByDadOld);
            Person grandFatherByDadOld = createPerson();
            list5.add(grandFatherByDadOld);
            map.put(grandMotherByMom, list5);
        } else if (choise == 2) {
            System.out.println("Ok!");
        }
        System.out.println(map);
        for (Map.Entry<Person, List<Person>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
