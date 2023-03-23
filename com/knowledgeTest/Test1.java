package com.knowledgeTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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
    @Test
    public void StringTest(){
        String a = "abc";
        String b = "a"+"bc";
        System.out.println(a==b);


    }
    @Test
    public void CollectionTset() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer max = Collections.max(list);
        int i = Collections.binarySearch(list, 1);
        Collections.reverse(list);
        System.out.println(list);
    }

    public void HashMapSecurity(){
        HashMap<Integer,Integer> map = new HashMap<>();
        ConcurrentHashMap<Integer,Integer> map1 = new ConcurrentHashMap<>();
    }
}
