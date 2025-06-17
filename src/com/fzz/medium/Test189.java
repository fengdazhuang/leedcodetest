package com.fzz.medium;


public class Test189 {
    public static void main(String[] args) {
        int nums[]=new int[]{1,2,3,4,5,6,7};
        int res[] = rotate(nums,3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(nums[i]);
        }
    }


    public static int[] rotate(int[] nums, int k) {
        //线性代数法，前n-k个和后k个分别求倒置，再整体求倒置
        int len=nums.length;

        reverse(nums,0,len-k-1);
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-1);
        return nums;
    }

    public static void reverse(int[] nums,int begin,int end){
        for(int i=begin,j=0;i<=(end+begin)/2;i++,j++){
            int temp=nums[i];
            nums[i]=nums[end-j];
            nums[end-j]=temp;
        }
    }


}
