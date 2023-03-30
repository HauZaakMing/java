package com.leetcode;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Queue;

public class leetcode_346 {

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        ma.next(1);
        ma.next(10);
        ma.next(3);
        ma.next(5);
    }
}
class MovingAverage {
    int size;
    Deque<Double> deque;

    double curMean = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        deque = new ArrayDeque<>();
    }

    public double next(int val) {
        deque.addLast(val+0.0);

        if(deque.size()>size){
            curMean = curMean-deque.pollFirst()/size+(val+0.0)/size;
        }else{
            curMean = ((curMean*(deque.size()-1))+val)/deque.size();
        }
        return curMean;
    }
}