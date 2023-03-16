package com.knowledgeTest;

import org.junit.Test;

public class Test1 {

    @Test
    public void gression(){
        Integer i = 4;
        String a = "123";
        System.out.println(Integer.toBinaryString(i>>1));
        System.out.println(Integer.toBinaryString(i>>2));
        System.out.println(Integer.toBinaryString(i>>3));
        Test1 demo = new Test1();
        Class<? extends Test1> aClass = demo.getClass();
        System.out.println(aClass);
        ClassLoader classLoader = aClass.getClassLoader();
//        classLoader.loadClass()
        System.out.println(classLoader);
    }
}
