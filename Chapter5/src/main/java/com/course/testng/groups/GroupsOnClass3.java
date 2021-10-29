package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.printf("GroupsOnClass3中的teacher1运行\n");
    }

    public void teacher2(){
        System.out.printf("GroupsOnClass3中的teacher2运行\n");
    }
}
