package com.leetcode;

public class leetcode_1616 {

    public boolean checkPalindromeFormation(String a, String b) {

        if(checkH(a)||checkH(b)){
            return true;
        }
        boolean flag1 = true;
        boolean flag2 = true;
        //要是前后不一，就是没有希望
        //a当前缀
        if(a.charAt(0)==b.charAt(b.length()-1)){
            int p1 = 0;
            int p2 = a.length()-1;
            while(p1<p2){
                if(a.charAt(p1)==b.charAt(p2)){
                    p1++;
                    p2--;
                }else{
                    break;
                }


            }
            //之后就要检查中间这段是否回文
            if(checkH(a.substring(p1,p2+1))||checkH(b.substring(p1,p2+1))){
                return true;
            }else{
                return false;
            }
        }
        //b当前缀
        if(b.charAt(0)==a.charAt(a.length()-1)){
            int p1 = 0;
            int p2 = a.length()-1;
            while(p1<p2){
                if(b.charAt(p1)==a.charAt(p2)){
                    p1++;
                    p2--;
                }else{
                    break;
                }


            }
            //之后就要检查中间这段是否回文
            if(checkH(a.substring(p1,p2+1))||checkH(b.substring(p1,p2+1))){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }

    public boolean checkH(String s){
        int p1 = 0;
        int p2 = s.length()-1;
        while (p1<p2){
            if(s.charAt(p1)!=s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode_1616 demo = new leetcode_1616();
        demo.checkPalindromeFormation("abda","acmc");
    }
}
