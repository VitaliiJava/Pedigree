package com.lviv.pedigree;

/**
 * Создать приложение родословная.
 * Приложение должно позволять:
 * 1) Выводить родословное дерево конкретного человека.
 * 2) Показывать прямых родственников
 * 3) Вычислять статистику по всему дереву:
 * количество живых, мужчин/женщин, среднее количество детей, среднюю продолжительность жизни
 * 4) Отображать в дереве место и даты рождения и свадьбы, место жительства, профессию и другую информацию о персоне;
 * 5) Показывать прямых родственников с братьями и сёстрами, все родственники.
 * 6) Показывать степень родства двух людей.
 */

import java.util.Scanner;

/**
 * The class creates a menu for managing a pedigree application.
 *
 * @author Vitalii Prykhid
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Pedigree pedigree = new Pedigree();
        while (true) {
            pedigree.menu();
            String key = scanner.next();
            try {
                switch (key) {
                    case "1": {
                        pedigree.getTreeOfPerson();
                        break;
                    }
                    case "2": {
                        pedigree.getFromTreeOnlyNeibors();
                        break;
                    }
                    case "3": {
                        pedigree.getIsLifePersonFromTree();
                        break;
                    }
                    case "4": {
                        pedigree.getMaleOrFemaleFromTree();
                        break;
                    }
                    case "5": {
                        pedigree.getAvgOfChildrenFromTree();
                        break;
                    }
                    case "6": {
                        pedigree.getAvgOfLongLifeFromTree();
                        break;
                    }
                    case "7": {
                        pedigree.getOnlyNeiborsWithBrothersAndSistersOrAllPersonFromTree();
                        break;
                    }
                    case "8": {
                        pedigree.getPositionBetweenTwoPersonsFromTree();
                        break;
                    }
                    case "9": {
//                        pedigree.createTree();
                        break;
                    }
                    case "10":
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
    }
}