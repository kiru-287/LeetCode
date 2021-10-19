/*
* https://leetcode.com/problems/contains-duplicate/
* Given an integer array nums, return true if any value appears at least twice in the array,
* and return false if every element is distinct.
 */

package git.leetCode.dataStructure14Days;

import java.util.Arrays;

public class ContainsDuplicate_217 {
    public static void main(String[] args) {
        containsDuplicate(new int[]{1,6,7,3,1}); //true
        containsDuplicate(new int[]{1,6,7,3,2}); //false
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-1) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
            i++;
        }
        return false;
    }
}
