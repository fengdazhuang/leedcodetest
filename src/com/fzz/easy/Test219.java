package com.fzz.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test219 {
    public static void main(String[] args) {
        int[] nums={1,0,1,1};
        int k=1;
        System.out.println(new Solution219().containsNearbyDuplicate2(nums,k));
    }
}

/**
 * 两种方法：
 * 1：可以直接双层for循环，判断nums[i]==nums[j]相等时返回true，因为|i-j|<=k，所以内循环的结束条件写为当j<=k+i时结束
 *    时间复杂度：O(k*n)=>O(n)
 * 2：用map存储值对应的索引下标，遍历过程中发现map有该值就判断两者索引是否在范围内，在就直接返回，否则更新key-value
 *    时间复杂度：O(n)
 */
class Solution219 {
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j<=k+i&&j<nums.length;j++)
                if(nums[i]==nums[j])
                    return true;
        }
        return false;
    }
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int num=nums[i];
            if(map.containsKey(num)){
                if(i-map.get(num)<=k)
                    return true;
            }
            map.put(num,i);
        }
        return false;
    }

}