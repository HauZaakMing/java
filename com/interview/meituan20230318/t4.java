package com.interview.meituan20230318;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class t4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int prex = x;
        int y = sc.nextInt();
        //贪心策略
        PriorityQueue<Node> prices = new PriorityQueue<>(((o1, o2) -> o1.num- o2.num));
        PriorityQueue<Node> pricesDis = new PriorityQueue<>(((o1, o2) -> o1.num- o2.num));

        for (int i = 0; i < n; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            Node n1 = new Node(p1,i);
            Node n2 = new Node(p2,i);
            prices.add(n1);
            pricesDis.add(n2);

        }
        HashSet<Integer> picked = new HashSet<>();
        int count =0;
        //先买打折的
        while(x>0&&y>0){
            Node n_temp = pricesDis.poll();
            if(n_temp.num<=x){
                x-=n_temp.num;
                y--;
                picked.add(n_temp.tag);
                count++;
            }
        }
        //再买不打折的
        while(x>0){
            Node n_temp = prices.poll();
            if(picked.contains(n_temp.tag)){
                continue;
            }else{
                if(x>= n_temp.num){
                    x-= n_temp.num;
                    count++;
                }
            }
        }
        System.out.println(count+" "+(prex-x));

    }




}
class Node{
    int num;
    int tag;

    public Node(int num, int tag) {
        this.num = num;
        this.tag = tag;
    }
}
