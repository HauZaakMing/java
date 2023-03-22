package com.knowledgeTest.AnnoymousAndThis;

import java.lang.reflect.Type;

public class pig {

    public pig(){
        System.out.println("hi");
        Class aClass = this.getClass();
        Type genericSuperclass = aClass.getSuperclass();
    }
}
