package com.gsy.gsy_common_util.common;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

    /**
     * 输入一个int数组，直接原地乱序。返回值为空
     * @param arr
     */
    public static void randomIntArray(int[] arr){
        Random random = new SecureRandom();
        int n = arr.length;
        for (; n > 0 ;n--) {
            int j = random.nextInt(n);
            swap(arr,n-1,j);
        }
    }
    private static void swap(int []arr,int i,int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * 从start开始 到 end结束 ，左闭右开
     * @param start
     * @param end
     * @param step
     * @return
     */
    public static int[] randomIntArray(int start,int end, int step) {
        if (step<1){
            return new int[0];
        }
        int arr[] = new int[(end-start)/step];
        int index = 0;
        for (int i = start; i < end; i+=step) {
            arr[index++] = i;
        }
//        System.out.println(Arrays.toString(arr));
        randomIntArray(arr);
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * 生成一个长度为length的int乱序数组
     * @param length
     * @return int[]型数组
     */
    public static int[] randomIntArray(int length) {
        return randomIntArray(0,length,1);
    }
}
