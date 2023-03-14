package com.leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

public class tools {


    //判断两个数字是否互质   互余再余余数
    public boolean gca (int a ,int b){
        boolean flag = true;

        int t = a%b;
        while(t!=0){
            a=b;
            b=t;
            t=a%b;
        }
        return b==1;
    }

    //欧拉筛法，获得2到maxN的所有指数
    public static List<Integer> getPrimeL(int maxN){
        List<Integer> pl = new ArrayList<>();
        boolean []isprime = new boolean[maxN];
        Arrays.fill(isprime,true);
        isprime[1] = false;
        for (int i = 2; i < maxN; i++) {
            if(isprime[i]){
                pl.add(i);
            }
            for (int j = 0; j < pl.size() && i*pl.get(j)<maxN ; j++) {
                isprime[i*pl.get(j)] = false;
                if(i%pl.get(j)==0) break;
            }

        }
        return pl;
    }

    public static TreeNode String2BTree(String s){
        String []splits = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        linkNode(root,splits,1);

        return root;

    }

    public static void linkNode(TreeNode root,String []splits,int curpos){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()&&curpos<splits.length){
            TreeNode curNode = queue.poll();
            if(!splits[curpos].equals("null")){
                TreeNode l = new TreeNode(Integer.parseInt(splits[curpos]));
                queue.add(l);
                curNode.left = l;
            }
            curpos = curpos+1;
            if(curpos<splits.length&&!splits[curpos].equals("null")){
                TreeNode r = new TreeNode(Integer.parseInt(splits[curpos]));
                queue.add(r);
                curNode.right = r;
            }
            curpos = curpos+1;
        }


    }


    public static void main(String[] args) {
        String2BTree("10,5,-3,3,2,null,11,3,-2,null,1");
    }





}


