package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.printf("这是服务端组的测试方法1111\n");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.printf("这是服务端组的测试方法2222\n");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.printf("这是客户端组的测试方法3333\n");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.printf("这是客户端组的测试方法4444\n");
    }

    @BeforeGroups("server")
    public void beforeGroupOnServer(){
        System.out.printf("这是服务端组运行之前运行的方法\n");
    }

    @AfterGroups("server")
    public void afterGroupOnServer(){
        System.out.printf("这是服务端组运行之后运行的方法\n");
    }

    @BeforeGroups("client")
    public void beforeGroupOnClient(){
        System.out.printf("这是客户端组运行之前运行的方法\n");
    }

    @AfterGroups("client")
    public void afterGroupOnClient(){
        System.out.printf("这是客户端组运行之后运行的方法\n");
    }


}
