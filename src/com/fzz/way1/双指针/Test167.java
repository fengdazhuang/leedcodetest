package com.fzz.way1.双指针;

/*
167. 两数之和 II - 输入有序数组

给你一个下标从 1 开始的整数数组 numbers ，该数组已按非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
你所设计的解决方案必须只使用常量级的额外空间。
 */


/*
示例 1：

输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int[] res = new Solution167().twoSum2(numbers, 9);
        Arrays.stream(res).forEach(System.out::println);
    }
}

class Solution167 {
    //解1：hashmap方法
    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{Math.min(map.get(target-numbers[i])+1,i+1),
                        Math.max(map.get(target-numbers[i])+1,i+1)};
            }else{
                map.put(numbers[i],i);
            }

        }
        return null;
    }

    //解2：双指针方法
    //已知数组为排过序的
    public int[] twoSum2(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        while(left!=right){
            if(numbers[left]+numbers[right]<target){
                left++;
            }else if(numbers[left]+numbers[right]>target){
                right--;
            }else if(numbers[left]+numbers[right]==target){
                return new int[]{left+1,right+1};
            }
        }
        return null;
    }
}
