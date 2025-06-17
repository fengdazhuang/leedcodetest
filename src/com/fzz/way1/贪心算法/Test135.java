package com.fzz.way1.贪心算法;

public class Test135 {
    public static void main(String[] args) {
        int[] ratings={1,0,2};
        int candy = new Solution135().candy(ratings);
        System.out.println(candy);
    }

/*
    把所有孩子的糖果数初始化为 1 ；
    先从左往右遍历一遍，如果右边孩子的评分比左边的高，则右边孩子的糖果数更新为左边孩子的
    糖果数加；再从右往左遍历一遍，如果左边孩子的评分比右边的高，且左边孩子当前的糖果数
    不大于右边孩子的糖果数，则左边孩子的糖果数更新为右边孩子的糖果数加。通过这两次遍历，
    分配的糖果就可以满足题目要求了。这里的贪心策略即为，在每次遍历中，只考虑并更新相邻一
    侧的大小关系。
 */

}
class Solution135 {
    public int candy(int[] ratings) {
        int len=ratings.length;
        int[] res=new int[len];
        int count=0;
        for(int n=0;n<len;n++){
            res[n]=1;
        }
        for(int i=0;i<len-1;i++){
            if(ratings[i]<ratings[i+1]){
                res[i+1]=res[i]+1;
            }
        }
        for(int j=len-1;j>0;j--){
            if(ratings[j]<ratings[j-1]&&res[j-1]<=res[j]){
                res[j-1]=res[j]+1;
            }
        }
        for(int m=0;m<res.length;m++){
            count=count+res[m];
        }
        return count;

    }
}