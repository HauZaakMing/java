package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class leetcode_1487 {


    public String[] getFolderNames(String[] names) {
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        Pattern p = Pattern.compile("(\\d+)");
        for (int i=0;i<names.length;i++) {
            String s = names[i];
            Matcher m = p.matcher(s);
            //以前出现过的，那就从map直接获取以前这个字符串的后缀
            if(set.contains(s)){
                int fileN = map.get(s);
                String newS = s+"("+(fileN+1)+")";
                names[i] = newS;
                map.put(s,fileN+1);
                set.add(newS);
                map.put(newS,0);

            //以前没出现过
            }else{
                set.add(s);
                map.put(s,0);
                //先看看是否有后缀,有后缀的，看看前面部分是否在库里
                if(m.find()){
                    int index = m.start(0);
                    int fileN = Integer.parseInt( m.group());
                    String filename = s.substring(0,index-1);
                    if(s.contains(filename)){
                        map.put(filename,fileN);
//                        names[i] = filename+"("+(fileN+1)+")";
                    }


                }
            }



        }
        return names;
    }


    public static void main(String[] args) {
        String []names = {"wano","wano","wano","wano"};

        leetcode_1487 demo = new leetcode_1487();
        System.out.println(Arrays.toString(demo.getFolderNames(names)));
    }
}
