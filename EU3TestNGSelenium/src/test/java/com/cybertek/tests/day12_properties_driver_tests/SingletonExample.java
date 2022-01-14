package com.cybertek.tests.day12_properties_driver_tests;

public final class SingletonExample {

    private SingletonExample(){} //here private prevents to create an object out of it

    private static String str; //since the variable is static, it belongs the Singleton class and whenever it's called
                                //the same assigned value is returned to the demanding side

    public static String getInstance(){

        if(str == null){
            System.out.println("Returning new value");
            str = "new value";
        }else {
            System.out.println("Returning the current value");
        }
        return str;

    }


}
