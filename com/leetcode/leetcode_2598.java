package com.leetcode;

import java.util.Arrays;

public class leetcode_2598 {

    public int findMinimumTime(int[][] tasks) {
        //按照结束时间进行排序，大的往后放
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        //获取最后的时间节点
        int u = tasks[tasks.length - 1][1];
        // 四倍最大末节点，必然大于线段树节点个数
        //用来记录对应线段树节点下有多少节点正在运行
        cnt = new int[u * 4];
        //
        todo = new boolean[u * 4];
        for (var t : tasks) {
            //每一遍历，检查当前区间内是否有正在运行的节点，有的话，减少需要布置的节点
            //然后去找未运行的节点布置剩余的任务，优先级是偏右的节点
            int start = t[0], end = t[1], d = t[2];
            suffix = d - query(1, 1, u, start, end);  // 去掉运行中的时间点
            if (suffix > 0) update(1, 1, u, start, end); // 新增时间点
        }
        return cnt[1];
    }

    private int[] cnt;
    private boolean[] todo;
    private int suffix;

    //标记这一片全被占用
    private void do_(int o, int l, int r) {
        cnt[o] = r - l + 1;
        todo[o] = true;
    }

    //将懒标签下移
    void spread(int o, int l, int m, int r) {
        if (todo[o]) {
            do_(o * 2, l, m);
            do_(o * 2 + 1, m + 1, r);
            todo[o] = false;
        }
    }

    // 查询区间 [L,R]   o,l,r=1,1,u
    // 小o是线段树节点号，小l小r是当前线段树的节点范围，大L大R是查询范围
    int query(int o, int l, int r, int L, int R) {
        //要是查询范围被包含在该节点的范围里，可以直接返回
        if (L <= l && r <= R) return cnt[o];
        //要是不是，那就分治，左右各自检查
        int m = (l + r) / 2;
        // 当前节点不满足，需要向下了，所以懒标签得往下传
        spread(o, l, m, r);
        if (m >= R) return query(o * 2, l, m, L, R);
        if (m < L) return query(o * 2 + 1, m + 1, r, L, R);
        return query(o * 2, l, m, L, R) + query(o * 2 + 1, m + 1, r, L, R);
    }

    // 新增区间 [L,R] 后缀的 suffix 个时间点    o,l,r=1,1,u
    // 相当于把线段树二分和线段树更新合并成了一个函数，时间复杂度为 O(log u)
    void update(int o, int l, int r, int L, int R) {
        int size = r - l + 1;

        if (cnt[o] == size) return; // 全部为运行中
        //要是查询区间就在线段树节点的范围内，且剩余未启动节点小于等于需求
        if (L <= l && r <= R && size - cnt[o] <= suffix) { // 整个区间全部改为运行中
            suffix -= size - cnt[o];
            do_(o, l, r);
            return;
        }
        //要是不需要全部启动，那就先看右边是否在搜索范围内，是的话，搜索右边
        int m = (l + r) / 2;
        spread(o, l, m, r);
        if (m < R) update(o * 2 + 1, m + 1, r, L, R); // 先更新右子树
        if (suffix > 0) update(o * 2, l, m, L, R); // 再更新左子树（如果还有需要新增的时间点）
        cnt[o] = cnt[o * 2] + cnt[o * 2 + 1];
    }
}
