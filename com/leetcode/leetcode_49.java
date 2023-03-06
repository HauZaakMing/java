package com.leetcode;

import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        //存放相应的key值和其对应的在list的位置
        HashMap<String,Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String str:
             strs) {
            String key = getB(str);
            if(map.containsKey(key)){
                ans.get(map.get(key)).add(str);
            }else{
                map.put(key,ans.size());
                List<String> temp = new ArrayList<>();
                temp.add(str);
                ans.add(temp);
            }
        }
        return ans;
    }

//    利用字典序最小的字符串即可以作为单一key
    public static String getB (String str){

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        return key;


    }

    public static void main(String[] args) {
//        System.out.println(getB("tae"));
//        System.out.println(getB("tea"));
        leetcode_49 demo = new leetcode_49();
        demo.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
