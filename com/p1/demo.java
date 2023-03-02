package com.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class book {
    String name;
    String publication;
    Double price;

    book(String name, String publication, Double price) {
        this.name = name;
        this.publication = publication;
        this.price = price;
    }

    public String toString() {
        return name + publication + price;
    }

}

public class demo {

    public static void main(String[] args) {
        ArrayList<book> a = new ArrayList<>();
        book b1 = new book("java", "mingri", 59.8);
        book b2 = new book("Android", "mingri", 60.0);
        book b3 = new book("IOS", "mingri", 61.0);
        a.add(b1);
        a.add(b2);
        a.add(b3);
        Iterator<book> it = a.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        int[] array = new int[] { 11, 2 };
    }
}
