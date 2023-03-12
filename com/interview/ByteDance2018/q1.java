package com.interview.ByteDance2018;



import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


class Node{
    int x;
    int y;

    boolean flag;

    public Node(int x, int y, boolean flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
    }
}
public class q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> list = new ArrayList<>();
        int n = sc.nextInt();
        PriorityQueue<Node> queue = new PriorityQueue<Node>(((o1, o2) -> o1.x-o2.x));
//        queue.
//        for (int i = 0; i < n; i++) {
//            queue.add
//        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(list.isEmpty()){
                list.add(new Node(x,y,true));
            }else{
                boolean Flag = true;
                for (Node node :
                        list) {

                    int nx = node.x;
                    int ny = node.y;
                    if(x>nx&&y>ny){
                        node.flag=false;
                    } else if (nx>x&&ny>y) {
                        Flag = false;
                    }

                }
                if(Flag){
                    list.add(new Node(x,y,true));
                }
            }


        }
//        PriorityQueue<Node> queue = new PriorityQueue<Node>(((o1, o2) -> o1.x-o2.x));
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).flag==true){
                Node temp = list.get(i);
                queue.add(temp);
            }
        }

        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.x+" "+ temp.y);
        }


    }

}

