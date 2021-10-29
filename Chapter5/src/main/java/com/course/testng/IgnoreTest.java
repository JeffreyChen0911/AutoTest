package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.printf("ignore1 执行！\n");
    }

    @Test(enabled =  false)
    public void ignore2(){
        System.out.printf("ignore2 执行！\n");
    }

    @Test(enabled =  true)
    public void ignore3(){
        System.out.printf("ignore3 执行！\n");
    }
}
