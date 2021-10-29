package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * TestNG组测试
 */
@Test(groups = "stu")
public class GroupsOnClass1 {

    public void stu1(){
        System.out.printf("GroupsOnClass1中的stu1运行\n");
    }

    public void stu2(){
        System.out.printf("GroupsOnClass1中的stu2运行\n");
    }
}
