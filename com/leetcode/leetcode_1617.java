package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class leetcode_1617 {
    //未完成
//    HashSet<Integer> adjacent = new HashSet<>();
    ArrayList<Integer> []adjacent;
    int []picked;
    int []visited;
    int n;
    int []ans;
    int diameter;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        this.n = n;
        adjacent = new ArrayList[n];
        visited = new int[n];
        picked = new int[n];
        ans = new int[n-1];
        Arrays.setAll(adjacent, e -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int e = edges[i][1];
            adjacent[s - 1].add(e - 1);
            adjacent[e - 1].add(s - 1);

        }
        iterate(0);
        return ans;
    }

    public void iterate(int pos){
        //位置到了
        if(pos == n){
            for (int i = 0; i < n; i++) {
                if(picked[i]==1){
                    visited = new int[n];
                    visited[i] = 1;
                    diameter = 0;
                    getHeight(i);
                    break;
                }
            }
            if(Arrays.equals(visited,picked)&&diameter>0){
                ans[diameter-1]++;
            }
            
        }else{
            //不要这个点
            iterate(pos+1);
            //要这个点
            picked[pos] = 1;
            iterate(pos+1);
            //恢复
            picked[pos] = 0;
        }
    }
    
    public int getHeight(int i){
        int maxlength = 0;

        for (Integer next:
             adjacent[i]) {
            if(visited[next]==0&&picked[next]==1){
                visited[next] = 1;
                int temp = getHeight(next)+1;
                if(temp+maxlength>diameter){
                    diameter = temp+maxlength;
                }
                if(temp>maxlength){
                    maxlength = temp;
                }
            }

        }
        return maxlength;
    }



    public static void main(String[] args) {
        leetcode_1617 demo = new leetcode_1617();
        demo.countSubgraphsForEachDiameter(4,new int[][]{{1,2},{2,3},{2,4}});
    }

//    private List<Integer>[] g;
//    private boolean[] inSet, vis;
//    private int[] ans;
//    private int n, diameter;
//
//    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
//        this.n = n;
//        g = new ArrayList[n];
//        Arrays.setAll(g, e -> new ArrayList<>());
//        //将所有连通信息存进g中
//        for (var e : edges) {
//            int x = e[0] - 1, y = e[1] - 1; // 编号改为从 0 开始
//            g[x].add(y);
//            g[y].add(x); // 建树
//        }
//        //最终结果会保存在ans
//        ans = new int[n - 1];
//        //inSet用来记录当前在子集的元素有哪些
//        inSet = new boolean[n];
//        //从哪个城市开始
//        f(0);
//        return ans;
//    }
//
//
//    private void f(int i) {
//        //每个城市都会经历01选择，然后到此就要验证其
//        if (i == n) {
//            for (int v = 0; v < n; ++v)
//                //长到一个在数据集中的点，开始DFS，DFS结束就停掉循环
//                if (inSet[v]) {
//                    vis = new boolean[n];
//                    diameter = 0;
//                    dfs(v);
//                    break;
//                }
//            //当直径不为0，且全连通才会统计最终结果
//            if (diameter > 0 && Arrays.equals(vis, inSet))
//                ++ans[diameter - 1];
//            return;
//        }
//
//        // 不选城市 i
//        f(i + 1);
//
//        // 选城市 i
//        inSet[i] = true;
//        f(i + 1);
//        inSet[i] = false; // 恢复现场
//    }
//
//    // 求树的直径
//    private int dfs(int x) {
//        vis[x] = true;
//        int maxLen = 0;
//        //检查与x连通的所有节点，要是节点没被访问过就进去，计算该节点的最大深度
//        for (int y : g[x])
//            if (!vis[y] && inSet[y]) {
//                int ml = dfs(y) + 1;
//                // 直径的最大值更新，直径一定是当前最长线路和当前次长线路的总和
//                diameter = Math.max(diameter, maxLen + ml);
//                maxLen = Math.max(maxLen, ml);
//            }
//        return maxLen;
//    }



}
