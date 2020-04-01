package com.huawei;

import java.util.ArrayList;

public class test {
    static private int[] visited = {0, 0, 0, 0, 0, 0, 0};//7个节点,0为未访问
    static private int[][] e = {
            {0, 1, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0}};//邻接矩阵,值大家任意改.
    static ArrayList<Integer> trace = new ArrayList<Integer>();//从出发节点到当前节点的轨迹
    static boolean hasCycle = false;

    public static void main(String[] args) {
        findCycle(0);
        if (!hasCycle)
            System.out.println("No Cycle.");
    }

    static void findCycle(int v)   //递归DFS
    {
        if (visited[v] == 1) {
            int j;
            if ((j = trace.indexOf(v)) != -1) {
                hasCycle = true;
                System.out.print("Cycle:");
                while (j < trace.size()) {
                    System.out.print(trace.get(j) + " ");
                    j++;
                }
                System.out.print("\n");
                return;
            }
            return;
        }
        visited[v] = 1;
        trace.add(v);

        for (int i = 0; i < 7; i++) {
            if (e[v][i] == 1)
                findCycle(i);
        }
        trace.remove(trace.size() - 1);
    }
}
