package com.fzz.medium;

public class Test055 {
    /**
     * 注意：不要求正好能到达最后一个位置
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len=nums.length;
        //最远能到达位置的索引
        int mostReach=0;

        for(int i=0;i<len;i++){
            //判断是否当前位置可达
            if(i<=mostReach){
                //当前位置可达，更新最远能到达的位置索引
                mostReach=Math.max(mostReach,i+nums[i]);
                //判断是否已经可以到达最后一个位置
                if(mostReach>=len-1) return true;
            }

        }
        return false;
    }
}
