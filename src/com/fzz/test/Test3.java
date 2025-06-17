package com.fzz.test;

/**
 * 将总共m个萝卜种植到n个有序（序号为1-n）的坑中，序号1的坑种1个，序号2的坑种2个，序号n的坑种n个，
 * 如果不够则将所有萝卜种在当前坑，如果n个坑都种完了还有剩，那么重新从第1个坑开始添加。要求返回一个长度n的数组，
 * 分别表示n个坑对应的萝卜数。其中：
 * （1）m为大于0的整数，n为大于0的整数，返回的数组下标0对应1号坑，如此类推
 * （2）示例：m=10，n=3，那么最终结果为[2, 4, 4]，第二轮到3号坑时只剩1个，全部种入
 */
public class Test3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] method1 = method1(1000, 1000000000);
        long end = System.currentTimeMillis();
        System.out.println("method1执行时间：" + (end - start) + "ms");
//        System.out.println("method1执行时间：" + (end - start) + "ms\n"+"结果为："+Arrays.toString(method1));
        start = System.currentTimeMillis();
        int[] method2 = method2(1000, 1000000000);
        end = System.currentTimeMillis();
        System.out.println("method2执行时间：" + (end - start) + "ms");  //方法二更快
//        System.out.println("method2执行时间：" + (end - start) + "ms\n"+"结果为："+Arrays.toString(method2));

    }

    public static int[] method1(int n,int num){
        int[] hole=new int[n];
        int remain=num;
        int i=1;
        while(remain>i){
            hole[i-1]=hole[i-1]+i;
            remain=remain-i;
            if(i==n){
                i=1;
            }else{
                i++;
            }
        }
        hole[i-1]=hole[i-1]+remain;
        return hole;
    }

    public static int[] method2(int n,int num){
        int[] hole=new int[n];
        int remain=num;
        int i=1;
        int one=n*(n+1)/2;  //一轮需要的数量
        int number=remain/one;   //轮数
        remain=remain%one;      //number轮分配后剩余量
        for(int a=1;a<=n;a++){
            hole[a-1]=a*number;
        }
        while(remain>=i){
            hole[i-1]=hole[i-1]+i;
            remain=remain-i;
            i++;
        }
        hole[i-1]=hole[i-1]+remain;
        return hole;
    }
}
