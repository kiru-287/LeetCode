/*
* https://leetcode.com/problems/merge-sorted-array/
* You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
* representing the number of elements in nums1 and nums2 respectively.
 */

package git.leetCode.dataStructure14Days;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6},3); //[1,2,2,3,5,6]
        merge(new int[]{1}, 1, new int[]{},0); //[1]
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for(int i=m ; i<nums1.length ; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    }
}
