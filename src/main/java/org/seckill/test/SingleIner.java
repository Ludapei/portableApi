package org.seckill.test;

public class SingleIner {
    private SingleIner() {

    }
    private static class SingleInnerInstance {
        private static final SingleIner singleIner = new SingleIner();

    }


    public static SingleIner getInstance() {
        return SingleInnerInstance.singleIner;
    }

    public void say() {
        System.out.println("hello");
    }


    public static void main(String[] args) {
        SingleIner.getInstance().say();
    }



}
