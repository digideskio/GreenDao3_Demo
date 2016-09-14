package demo.greendao.acewill.com.greendao3_demo;

import android.util.Log;

public class Calculator {

    private static final String TAG = Calculator.class.getSimpleName();

    public double sum(double a, double b) {
        Log.i(TAG,"计算:"+a+"加"+b);
       return a+b;
    }

    public double substract(double a, double b) {
        return a-b;
    }

    public double divide(double a, double b) {
        return a*b;
    }

    public double multiply(double a, double b) {
        return a/b;
    }
}