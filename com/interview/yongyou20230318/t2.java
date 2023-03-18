package com.interview.yongyou20230318;

public class t2 {

    public String[] sortNickName(String[] nickNameArray) {
        // write code here
        int right = nickNameArray.length-1;
        for (int i = nickNameArray.length-1; i >= 0; i--) {
            if(nickNameArray[i]!=""){
                continue;
            }else{//出现“”,将它后移
                int p = i+1;
                while(p<=right){
                    swap(nickNameArray,p-1,p);
                    p++;
                }
                right--;
            }

        }
        return nickNameArray;
    }

    public static void swap(String[] strs, int lp, int rp) {
        String temp = strs[lp];
        strs[lp] = strs[rp];
        strs[rp] = temp;
    }

    public static void main(String[] args) {
        t2 demo = new t2();
//        demo.sortNickName(new String[]{"louis","john","tom","","jerry","rabbit",""});
        demo.sortNickName(new String[]{"jack","","tomato","","taga"});
    }
}
