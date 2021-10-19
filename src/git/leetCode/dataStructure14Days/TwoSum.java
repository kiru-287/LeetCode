/*
* https://leetcode.com/problems/two-sum/
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
* You can return the answer in any order.
 */

package git.leetCode.dataStructure14Days;

public class TwoSum {

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9); //[0, 1]
        twoSum(new int[]{3,2,4},6); //[1, 2]
    }

    public static int[] twoSum(int[] nums, int target) {
        int sum;
        for(int i=0 ; i<nums.length-1 ; i++) {
            for(int j=i+1 ; j<nums.length ; j++) {
                sum = nums[i] + nums[j];
                if(sum == target)
                    return new int[]{i,j};
            }
        }
        return null;
    }
}
