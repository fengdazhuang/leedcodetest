package com.fzz.medium;

import java.util.*;

public class Test015 {
    public static void main(String[] args) {
//        int[] nums={0,0,0,0};
        int[] nums={2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};  // -4,-1,-1,0,1,2
        Solution015 solution=new Solution015();
        System.out.println(solution.threeSum(nums));
    }
}


/**
 * 要点：
 * 1）三个数和为0，不可能全为正数或全为负数
 * 2）三数之和的问题可以转化为两数之和的问题，固定一个点
 * 3）三个数中最多有两个数相等
 * 优化：
 * 1）最多有两个数一样，当x出现三次时可以直接跳出当前循环
 * 2）每次循环找两数之和时可以用hashmap存储添加过的两个数，避免重复添加
 */

class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //先升序排序
        Arrays.sort(nums);
        //三个数和为0，就不可能全为负或全为正,若最大数<0或最小值>0，直接返回空列表
        if(nums[len-1]<0||nums[0]>0){
            return res;
        }
        if(nums[0]==nums[len-1]){
            res.add(Arrays.asList(0,0,0));
            return res;
        }
        int x=0;
        int count=0,temp=Integer.MAX_VALUE;
        //先确定其中的一个，转换为求两个数和的问题
        while(x<len-2){
            //当最小值大于0时，直接返回，
            if(nums[x]>0) break;
            //当固定的x出现三次直接跳过当次循环
            if(temp==nums[x]){
                if(++count==3){
                    x++;
                    continue;
                }
            }else{
                count=1;
                temp=nums[x];
            }
            int target=nums[x]*(-1);
            int left=x+1,right=len-1;
            Map<Integer,Integer> map = new HashMap<>();
            //求和为target即x的相反数的两个数，组成三元组添加到res中
            while(left<right){
                if(nums[left]+nums[right]==target){
                    if(!map.containsKey(nums[left])){
                        res.add(Arrays.asList(target*(-1),nums[left],nums[right]));
                    }
                    map.put(nums[left],nums[right]);
                    left++;
                    right--;
                }else if(nums[left]+nums[right]<target){
                    left++;
                }else{
                    right--;
                }
            }
            x++;
        }
        //直接对结果去重，优化不彻底，还是出现了重复三元组
        return res.stream().distinct().toList();
    }

}