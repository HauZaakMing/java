package com.sword2offer;

public class q_46 {
    //剑指 Offer 46. 把数字翻译成字符串


    public int dp[];
    public int translateNum(int num) {
        String s = Integer.toString(num);
        dp = new int[s.length()];
        return findMatch(0,s);
    }

    public int findMatch(int pos,String s){
        if(pos==s.length()){
            return 1;
        }
        if(dp[pos]!=0){
            return dp[pos];
        }
        int count = 0;
        //选择前两位数字
        if(pos<s.length()-1&&s.charAt(pos)!='0'){
            String tmp = s.substring(pos,pos+2);
            int num = Integer.parseInt(tmp);
            if(num>=0&&num<=25){
                count +=findMatch(pos+2,s);
            }
        }
        //选择一位数字
        count+=findMatch(pos+1,s);
        dp[pos] = count;
        return count;
    }

    public static void main(String[] args) {
        q_46 demo = new q_46();
        demo.translateNum(25);
    }


}
