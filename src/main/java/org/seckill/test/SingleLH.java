package org.seckill.test;

public class SingleLH {

    private SingleLH() {
    }

    private static SingleLH singleLH = null;

    public static  SingleLH getInstance() {
        if (singleLH == null) {
            singleLH = new SingleLH();
        }
        return singleLH;
    }


    public static synchronized SingleLH getInstance2() {
        if (singleLH == null) {
            singleLH = new SingleLH();
        }
        return singleLH;
    }

    public static void main(String args[]) {
        SingleEH singleEH = SingleEH.getInstance();

    }
}
