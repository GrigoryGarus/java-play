package Mentor1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


        class ContactMap {

}



public class Main {

    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static HashMap<String, Integer> getMap() {
        return map;
    }



    static void contactCreate(){
        System.out.println("Введите имя контакта:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println(name);
        System.out.println("Введите номер телефона:");
        Scanner scan1 = new Scanner(System.in);
        int phone = scan1.nextInt();
        map.put(name, phone);
        System.out.println(map);
        System.out.println("Контакт создан");
        contactMain();
    }


    static void contactFinder(){
        System.out.println("Введите имя контакта:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        //System.out.println(map);
        //System.out.println("Телефон: "+map.get(name));
        if (map.containsKey(name)){
            System.out.println("Телефон: "+map.get(name));
            contactModify(name);
        }
        System.out.println("Такого контакта нет");
        contactMain();

    }

    static void contactModify(String name){
        System.out.println("Выберите действие: 1. Изменить контакт. 2. Удалить контакт. 3. Главное меню.");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        if (choice ==1){
            System.out.println("Введите новый телефон контакта "+name);
            Scanner scan1 = new Scanner(System.in);
            int value = scan1.nextInt();
            map.put(name, value);
            System.out.println("Контакт "+name+" изменен.");
            contactMain();
        } else if (choice==2){
            map.remove(name);
            System.out.println("Контакт "+name+" удален.");
            contactMain();
        } else if (choice==3){
            contactMain();
        }
        else {
            System.out.println("Ошибка ввода. Повторите");
            contactModify(name);

        }

    }



    static void contactMain(){

        System.out.println("Выберите действие: 1. Создать контакт. 2. Поиск контатакта по имени.");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice ==1){
            contactCreate();
        } else if (choice==2){
            contactFinder();
        } else if (choice==3){

            System.out.println("Выход");
        }
        else {
            System.out.println("Ошибка ввода. Повторите");
            contactMain();

        }

    }
    public static void main(String[] args) {
        contactMain();
//        Main cm = new Main();
//        Map<String, Integer> map = cm.getMap();
//        map.put("u", 123);
//       System.out.println(map);
        // test 2222



    }
}
