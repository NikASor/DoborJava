package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);


        SLS saver = new SLS();


        Lesson lesson1 = new Lesson("10:10", "11:40", "1503", "Pavlova", "english");
        Lesson lesson2 = new Lesson("14:00", "15:30", "1409", "Khadiev", "aisd");

        SLS.addLesson(lesson1);
        SLS.addLesson(lesson2);


        Student student1 = new Student("Сорокин", "Никита", "11-005");
        Student student2 = new Student("Исламов", "Ивар", "11-003");


        ArrayList<String> monday = new ArrayList<>();
        ArrayList<String> tuesday = new ArrayList<>();
        ArrayList<String> wednesday = new ArrayList<>();
        ArrayList<String> thursday = new ArrayList<>();
        ArrayList<String> friday = new ArrayList<>();
        ArrayList<String> saturday = new ArrayList<>();
        ArrayList<String> sunday = new ArrayList<>();

        monday.add(lesson1.toString());
        monday.add(lesson2.toString());
        tuesday.add(lesson2.toString());
        wednesday.add(lesson1.toString());
        thursday.add(lesson1.toString());
        friday.add(lesson1.toString());
        saturday.add(lesson2.toString());
        sunday.add(lesson1.toString());


        student1.schedule.put("понедельник", monday);
        student1.schedule.put("вторник", tuesday);
        student1.schedule.put("среда", wednesday);
        student1.schedule.put("четверг", thursday);
        student1.schedule.put("пятница", friday);
        student1.schedule.put("суббота", saturday);
        student1.schedule.put("воскресенье", sunday);

        student2.schedule.put("понедельник", monday);
        student2.schedule.put("вторник", tuesday);
        student2.schedule.put("среда", wednesday);
        student2.schedule.put("четверг", thursday);
        student2.schedule.put("пятница", friday);
        student2.schedule.put("суббота", saturday);
        student2.schedule.put("воскресенье", sunday);


        SLS.addStudent(student1);
        SLS.addStudent(student2);
//
//        Student.showLessonsForWeek(1);


        while (true) {
            System.out.println("1. Добавить студента");
            System.out.println("2. Добавить пару");
            System.out.println("3. Удалить студента");
            System.out.println("4. Удалить пару");
            System.out.println("5. Отобразить всех студентов");
            System.out.println("6. Отобразить все пары");
            System.out.println("7. Расписание на неделю");
            System.out.println("8. Расписание на конкретный день");

            int x = scanner.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Инфо студента как в примере: Иванов,Иван,11-001");
                    String line = scanner.next();
                    String[] studentInfo = line.split(",");
                    Student student = new Student(studentInfo[0], studentInfo[1], studentInfo[2]);
                    saver.addStudent(student);
                    break;
                case 2:
                    System.out.println("Инфо пары как в примере: 10:10,11:40,1503,Павлова,Английский");
                    line = scanner.next();
                    String[] lessonInfo = line.split(",");
                    Lesson lesson = new Lesson(lessonInfo[0], lessonInfo[1], lessonInfo[2], lessonInfo[3], lessonInfo[4]);
                    saver.addLesson(lesson);
                    break;
                case 3:
                    System.out.println("Инфо студента как в примере: Иванов Иван");

                    saver.removeStudent("sa ba");
                    break;
                case 4:
                    System.out.println("Инфо пары как в примере: 14:00,15:30,1409,Хадиев,аисд");

                    saver.removeLesson("14:00,12:40,102,Busanov,math");
                    break;
                case 5:
                    saver.showStudents();
                    break;
                case 6:
                    saver.showLessons();
                    break;
                case 7:
                    System.out.println("Номер студента для расписания на неделю " +
                            "(не обращать внимания на первую цифру в результате)");

                    int number = scanner.nextInt();

                    Student.showLessonsForWeek(number);
                    break;
                case 8:
                    System.out.println("День недели и номер студента для расписания на этот день " +
                            "(не обращать внимания на первую цифру в результате)");

                    line = scanner.next();
                    number = scanner.nextInt();

                    Student.showLessonsForDay(line.toLowerCase(),number);
                    break;
            }

        }
    }
}
