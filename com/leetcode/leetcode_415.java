package com.leetcode;

public class leetcode_415 {

    public String addStrings(String num1, String num2) {

        String ans = "";
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int pre = 0;
        while(p1>=0&&p2>=0){
            int sum = pre+Integer.parseInt(num1.charAt(p1)+"")+Integer.parseInt(num2.charAt(p2)+"");
            pre = sum/10;
            ans = (sum%10)+ans;
            p1--;
            p2--;
        }
        while (p1>=0){
            int sum = pre+Integer.parseInt(num1.charAt(p1)+"");
            pre = sum/10;
            ans = (sum%10)+ans;
            p1--;
        }
        while (p2>=0){
            int sum = pre+Integer.parseInt(num2.charAt(p2)+"");
            pre = sum/10;
            ans = (sum%10)+ans;
            p2--;
        }
        if(pre!=0){
            ans = pre+ans;
        }
        return ans;
    }
}
