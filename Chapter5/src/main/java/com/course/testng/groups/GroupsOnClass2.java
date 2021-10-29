package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu1(){
        System.out.printf("GroupsOnClass2中的stu1运行\n");
    }

    public void stu2(){
        System.out.printf("GroupsOnClass2中的stu2运行\n");
    }
}
