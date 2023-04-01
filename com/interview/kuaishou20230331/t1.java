package com.interview.kuaishou20230331;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class t1 {
    public String maskPII(String s) {
        //email or phone number
        if(s.contains("@")){
            s = s.toLowerCase();
            String splitS[] = s.split("@");
            splitS[0] = splitS[0].charAt(0)+"*****"+splitS[0].charAt(splitS[0].length()-1);

            return splitS[0]+"@"+splitS[1];
        }else{
            //count number
            char[] chars = s.toCharArray();
            int count = 0;
            char tail[] = new char[4];
            for (int i = chars.length-1; i >= 0; i--) {
                if(chars[i]>='0'&&chars[i]<='9'){
                    if(count<4){
                        tail[4-count-1] = chars[i];
                    }
                    count++;
                }
            }
            String tailS = new String(tail);
            switch (count){

                case 10:
                    return "***-***-"+tailS;

                case 11:
                    return "+*-***-***-"+tailS;

                case 12:
                    return "+**-***-***-"+tailS;

                case 13:
                    return "+***-***-***-"+tailS;

            }
        }
        return null;
    }
}
