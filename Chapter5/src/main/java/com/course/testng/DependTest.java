package com.course.testng;

import org.testng.annotations.Test;

/**
 * TestNG依赖测试
 */
public class DependTest {

    @Test
    public void test1(){
        System.out.printf("test1 run\n");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.printf("test2 run\n");
    }
}
