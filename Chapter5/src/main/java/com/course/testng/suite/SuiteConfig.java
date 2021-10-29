package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.printf("\nbefore suite运行啦\n");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.printf("after suite 运行啦\n");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.printf("beforeTest 运行啦\n");
    }

    @AfterTest
    public void afterTest(){
        System.out.printf("afterTest 运行啦\n");
    }

}
