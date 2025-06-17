package com.fzz.way1.搜索算法.回溯法;

import java.util.ArrayList;
import java.util.List;

public class Test77 {
    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution77().combine(4, 2);
    }
}


class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        int[] comb=new int[k];
        int count=0;
        backTracking(res,comb,count,1,n,k);
        return res;
    }

    public void backTracking(List<List<Integer>> res,int[] comb,int count,int pos,int n,int k){
        if (count == k) {
            List<Integer> list=new ArrayList<>();
            for(int a:comb){
                list.add(a);
            }
            res.add(list);
            return;
        }
        for (int i = pos; i <= n; ++i) {
            comb[count++] = i; // 修改当前节点状态
            backTracking(res, comb, count, i + 1, n, k); // 递归子节点
            --count; // 回改当前节点状态
        }
    }

}
