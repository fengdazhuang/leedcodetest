package com.fzz.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class solve670 {//7236
    public int maximumSwap(int num) {
        int a=num;
        String str=num+"";
        int temp=0;
        int[] arr=new int[str.length()];
        int index=str.length()-1;
        int m=0;
        int res=0;
        while(num/10!=0){
            temp=num%10;
            num=num/10;
            arr[index--]=temp;
        }
        arr[index]=num;
        boolean flag=false;
        for(int j=0;j<arr.length-1;j++){
            if(arr[j]<arr[j+1]){
                flag=true;
            }
        }
        if(!flag){
            return a;
        }
        int begin=0;
        while(true){
            int maxIndex=max(arr,begin);
            if(maxIndex!=begin) {
                if(maxIndex==arr.length-1){
                    m=arr[maxIndex];
                    arr[maxIndex]=arr[begin];
                    arr[begin]=m;
                    break;
                }
                while (arr[max(arr, maxIndex + 1)] == arr[maxIndex]) {
                    maxIndex = max(arr, maxIndex + 1);
                    if(maxIndex==arr.length-1){
                        break;
                    }
                }
                m=arr[maxIndex];
                arr[maxIndex]=arr[begin];
                arr[begin]=m;
                break;
            }

            begin++;
        }

        for(int k=0;k<arr.length;k++){
            res=res*10+arr[k];
        }
        return res;


    }

    public static int max(int[] arr,int begin){
        int max=arr[begin];
        int index=begin;
        for(int i=begin+1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
                index=i;
            }
        }
        return index;
    }
}

public class Test670 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            int ret = new solve670().maximumSwap(num);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
