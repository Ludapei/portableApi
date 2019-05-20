package org.seckill.test;

public class SingleLHDC {

    private SingleLHDC() {
    }

    public static SingleLHDC singleLHDC=null;

    public static SingleLHDC getInstance() {
        if (singleLHDC == null) {
            synchronized (SingleLHDC.class) {
                if (singleLHDC == null) {
                    singleLHDC = new SingleLHDC();
                }
            }
        }
        return singleLHDC;
    }
}
