package com.keptrak.utilities;

public class BrowserUtilities {

     public static void waitMethod(){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void waitMethod(int number){

         number = number*1000;
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
