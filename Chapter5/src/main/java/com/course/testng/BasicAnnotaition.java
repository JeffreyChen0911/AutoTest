package com.course.testng;

import org.testng.annotations.*;

/**
 * TestNG执行顺序
 */
public class BasicAnnotaition {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.printf("Test这是测试用例1\n");
    }

    @Test
    public void testCase2(){
        System.out.printf("Test这是测试用例2\n");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.printf("BeforeMethod这是在测试方法之前运行的\n");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.printf("AfterMehod这是在测试方法之后运行的\n");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.printf("beforeClass这是在类运行之前运行的方法\n");
    }

    @AfterClass
    public void afterClass(){
        System.out.printf("afterClass这是在类运行之后运行的方法\n");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.printf("beforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.printf("afterSuite测试套件");
    }

}
