package com.leetcode;

public class leetcode_12 {
    public static String[] roman1 = {"I","X","C","M"};
    public static String[]  roman2 ={"V","L","D"};

    public String intToRoman(int num) {
        String ans = "";
        for (int i = 0; num>0  ; i++) {
            int temp = num%10;
            if(temp==4){
                ans = roman1[i]+roman2[i]+ans;

            }
            else if(temp==9){
                ans = roman1[i]+roman1[i+1]+ans;
            }else{
                if(temp>0&&temp<4){
                    for (int j = 0; j < temp; j++) {
                        ans = roman1[i]+ans;
                    }
                }
                else if(temp>=5){
                    for (int j = 5; j < temp; j++) {
                        ans = roman1[i]+ans;
                    }
                    ans = roman2[i]+ans;
                }
            }
            num = num/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_12 demo = new leetcode_12();
        demo.intToRoman(1994);
    }
}
