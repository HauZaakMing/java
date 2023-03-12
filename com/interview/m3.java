//import java.util.*;
//
//public class mt3 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        int[] starts=new int[n];
//        int[] ends=new int[n];
//        int max=Integer.MIN_VALUE;
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<n;i++){
//            starts[i]= sc.nextInt();
//            max=Math.max(max,starts[i]);
//            min=Math.min(min,starts[i]);
//        }
//        for(int i=0;i<n;i++){
//            ends[i]= sc.nextInt();
//            max=Math.max(max,ends[i]);
//            min=Math.min(min,ends[i]);
//        }
//        List<Interval> intervals=new ArrayList<>();
//        for (int i=0;i<n;i++){
//            Interval interval=new Interval(starts[i],ends[i]);
//            intervals.add(interval);
//        }
//        findPointInMostIntervals(intervals,max,min);
//    }
//
//    public static void findPointInMostIntervals(List<Interval> intervals,int max,int min) {
//        // Create a list of all the start and end points of the intervals
//
//        // Traverse the sorted list of points and keep track of the number of intervals that contain each point
//        int maxCount = 0;
//        int currentCount = 0;
//        int pointWithMaxCount = 0;
//        for (int point=min;point<max;point++) {
//            for (Interval interval : intervals) {
//                if (interval.start <= point && point <= interval.end) {
//                    currentCount++;
//                }
//            }
////            System.out.println(point+" "+currentCount);
//            if (currentCount > maxCount) {
//                maxCount = currentCount;
//                pointWithMaxCount=1;
//            } else if (currentCount == maxCount) {
//                pointWithMaxCount++;
//            }
//            currentCount = 0;
//        }
//        System.out.println(maxCount+" "+pointWithMaxCount);
//
////        return pointWithMaxCount;
//    }
//}
//
//class Interval {
//    int start;
//    int end;
//
//    public Interval(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//}