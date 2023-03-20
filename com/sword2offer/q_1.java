package com.sword2offer;

public class q_1 {
    public int divide(int a, int b) {
        long count = 0;
        if(a == Integer.MIN_VALUE&&b==Integer.MIN_VALUE){
           return 1;
        } else if (a == Integer.MIN_VALUE ) {
            if(b==1){
                return  Integer.MIN_VALUE;
            }
            else if(b==-1){
                return Integer.MAX_VALUE;
            }else{
                a = a+Math.abs(b);
                count+=1;
            }

        } else if ( b == Integer.MIN_VALUE) {
            return 0;
        } else if ( b==1) {
            return a;
        }

        int sign = sign(a,b);
        a = Math.abs(a);
        b = Math.abs(b);
        int tmp = b;
        int digitCount = 0;
        while(tmp>0){
            tmp = tmp>>1;
            digitCount++;
        }

        while(a>=b){
            int l = 0;
            int r = 32-digitCount-1;
            int mid = 0;
            while(l<r){
                mid = (l+r)>>1;

                if(a>(b<<mid)){
                    l = mid+1;
                } else if (a<(b<<mid)) {
                    r = mid-1;
                }else{
                    break;
                }
            }
            mid = (l+r)>>1;
            while(a<(b<<mid)){
                mid--;
            }
            a = a-(b<<(mid));
            count+=(1<<(mid));
            count = count%((1<<31)-1);
        }
        if(sign==1){
            return (int)-count;
        }else{
            return (int)count;
        }

    }

    //1 表示符号不同
    public static int sign(int a,int b){
        return ((a^b)>>31)&1;
    }

    public static void main(String[] args) {
        q_1 demo = new q_1();
        demo.divide(-2147483648,2);
    }
}
