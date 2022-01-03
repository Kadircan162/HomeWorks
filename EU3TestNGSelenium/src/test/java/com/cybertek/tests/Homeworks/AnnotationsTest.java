package com.cybertek.tests.Homeworks;

public class AnnotationsTest {

    public static void main(String[] args) {
        System.out.println("Object of Annotations super class");
        Annotations annotations = new Annotations();
        System.out.println("annotations.getX() = " + annotations.getX());
        annotations.setX(20);
        System.out.println("annotations.getX() = " + annotations.getX());

        System.out.println("Object of subclass of Annotations super class");
        AnnotationsSubClass annotationsSubClass = new AnnotationsSubClass();
        System.out.println("annotationsSubClass.getX() = " + annotationsSubClass.getX());
        annotationsSubClass.setX(30);
        System.out.println("annotationsSubClass.getX() = " + annotationsSubClass.getX());
    }
}
