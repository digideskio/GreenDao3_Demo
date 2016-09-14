package demo.greendao.acewill.com.greendao3_demo;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cxw on 2016/9/14.
 */
public class CalculatorTest {
    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator=new Calculator();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(3,mCalculator.sum(1,2),0);

    }

    @Test
    public void testSubstract() throws Exception {

    }

    @Test
    public void testDivide() throws Exception {

    }

    @Test
    public void testMultiply() throws Exception {

    }
}