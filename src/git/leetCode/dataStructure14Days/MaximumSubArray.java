/*
* https://leetcode.com/problems/maximum-subarray/
* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
* A subarray is a contiguous part of an array.
 */

package git.leetCode.dataStructure14Days;

public class MaximumSubArray {
    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}); //max = 6
        maxSubArray(new int[]{5,4,-1,7,8}); //max = 23
    }
    public static int maxSubArray(int[] nums) {
        int[] res = nums;
        int max = nums[0];
        for(int i=1 ;i<nums.length ; i++) {
            if(nums[i] < res[i-1]+nums[i]) {
                res[i] = res[i-1]+nums[i];
            }
            if(res[i] > max) {
                max = res[i];
            }
        }
        return max;
    }
}
