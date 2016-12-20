package com.lviv.pedigree;

import java.time.LocalDate;

public class Person {

    private Degree degree;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String cityOfBirth;
    private LocalDate dateOfWedding;
    private String cityOfLiving;
    private String profession;
    private int age;
    private Sex sex;
    private boolean isLive;

    public Person(Degree positionInLife, String firstName, String lastName, LocalDate dateOfBirth, String cityOfBirth, LocalDate dateOfWedding, String cityOfLiving, String profession, int age, Sex sex, boolean isLive) {
        this.degree = positionInLife;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.cityOfBirth = cityOfBirth;
        this.dateOfWedding = dateOfWedding;
        this.cityOfLiving = cityOfLiving;
        this.profession = profession;
        this.age = age;
        this.sex = sex;
        this.isLive = isLive;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public LocalDate getDateOfWedding() {
        return dateOfWedding;
    }

    public void setDateOfWedding(LocalDate dateOfWedding) {
        this.dateOfWedding = dateOfWedding;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public String toString() {
        return "Person{" +
                "degree=" + degree +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cityOfBirth='" + cityOfBirth + '\'' +
                ", dateOfWedding=" + dateOfWedding +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                ", profession='" + profession + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", isLive=" + isLive +
                "}\n";
    }
}
