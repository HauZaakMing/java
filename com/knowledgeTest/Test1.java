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

    //ArrayList的删除需要后面全部前移，继续按序号检索就会漏查
    @Test
    public void ArrayListCheck(){
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            a.add(i);

        }

        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);
            System.out.println(temp);
            if(i%10==0){

                a.remove(i);
            }
        }
        System.out.println(1);
    }
}
