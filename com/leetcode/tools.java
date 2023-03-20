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

    //数位dp模板
    public int[] dp;
    // pos 当前位置
    // mask 一些约束，或者需要往下传递的一些参数
    //isLimited 当前是否受原数字约束
    //isStart 是否已经开始摆数字
    public int findNoBigger(int pos,int curNum,boolean isLimited,boolean isStart,String number,HashSet<Integer> digs){
        //给定推出条件
        if(pos==number.length()){
            return isStart?1:0;
        }

        if(!isLimited&&isStart&&dp[pos]!=0){
            return dp[pos];
        }

        //给出上下界
        int cur = Integer.parseInt(number.substring(pos,pos+1));
        int upLimit = isLimited?cur:9;
        int lowLimit = isStart?0:1;

        //开始计数
        int count = 0;
        for (int i = lowLimit; i <= upLimit ; i++) {
            int tempNum = curNum+(int)(i*Math.pow(10,number.length()-pos-1));
            if(tempNum>Integer.parseInt(number)){
                break;
            }else{
                if(digs.contains(i)){
                    count+=findNoBigger(pos+1,tempNum,isLimited&&i==cur,true,number,digs);
                }else{
                    continue;
                }

            }
        }

        if(!isStart){
            count+=findNoBigger(pos+1,0,false,false,number,digs);
        }

        if(!isLimited&&isStart){
            dp[pos] = count;
        }
        return count;
    }


    public static void main(String[] args) {
        String2BTree("10,5,-3,3,2,null,11,3,-2,null,1");
    }





}


