package org.seckill.test;

import com.sun.org.apache.regexp.internal.RE;

public class SingleEH {

    private SingleEH() {

    }

    private static SingleEH singleEH = new SingleEH();

    public static SingleEH getInstance() {
        return singleEH;
    }
    public void say() {
        System.out.println("hello");
    }
    public static void main(String args[]) {
        SingleEH.getInstance().say();
    }
}
//    private SingleEH() {
//    }
//
//    private static SingleEH singleEH = new SingleEH();
//
//    public static SingleEH getInstance() {
//        return singleEH;
//    }
//
//    private void sayHello() {
//        System.out.println("hello");
//    }
//
//    public static void main(String aa[]) {
//        SingleEH singleEH = SingleEH.getInstance();
//        singleEH.sayHello();
//    }
