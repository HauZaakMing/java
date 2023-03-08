package com.leetcode;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class leetcode_207 {

    class Node{

        HashSet<Integer> pre = new HashSet<>();
        HashSet<Integer> next = new HashSet<>();

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            return true;
        }
        HashMap<Integer,Node> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i,new Node());
        }
        for (int[] pair :
                prerequisites) {
            int next = pair[0];
            int pre = pair[1];
            Node np = map.get(pre);
            np.next.add(next);
            Node pp = map.get(next);
            pp.pre.add(pre);
        }
        int count=0;
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Node> integerNodeEntry : map.entrySet()) {
            if(integerNodeEntry.getValue().pre.size()==0){
                queue.add(integerNodeEntry.getKey());
                count++;
            }
        }

        while(!queue.isEmpty()){
            int key = queue.poll();
            Node n = map.get(key);
            for (int k :
                    n.next) {
                Node cur = map.get(k);
                cur.pre.remove(key);
                if(cur.pre.size()==0){
                    queue.add(k);
                    count++;
                }
            }
        }
    if(count!=numCourses){
        return false;
    }else{
        return true;
    }

    }

    public static void main(String[] args) {
        leetcode_207 demo = new leetcode_207();
        demo.canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}});
    }
}
