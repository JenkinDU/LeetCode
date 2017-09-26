package com.leetcode;

public class TwoSum {

    public static void main(String[] args) {
        int[] number = new int[]{-1,2,3,4};
        twoSum(number, 7);
    }

    public static int[] twoSum(int[] nums, int target) {
        int max = 0;
        int min = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        if(min >= 0) {
            min = 0;
        }
        System.out.print("Max number is:"+max);
        System.out.print("Min number is:"+min);
        int[] numbers = new int[max+1-min];
        for(int n=0;n<max+1-min;n++) {
            numbers[n] = -1;
        }
        for(int i=0;i<nums.length;i++) {
            if(numbers[nums[i]-min] >=0 && 2*(nums[i]-min)==target-2*min) {
                return new int[]{numbers[nums[i]-min], i};
            } else {
                numbers[nums[i]-min] = i;
            }
        }
        for(int j=0;j<max+1-min;j++) { //[0,1,4,5]
            if(numbers[j] >= 0 && target-2*min-j < max+1-min && numbers[target-2*min-j] >=0) {
                return new int[]{numbers[j], numbers[target-2*min-j]};
            }
        }
        return null;
    }
}
