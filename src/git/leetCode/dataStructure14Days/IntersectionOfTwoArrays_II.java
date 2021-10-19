/*
* https://leetcode.com/problems/intersection-of-two-arrays-ii/
* Given two integer arrays nums1 and nums2, return an array of their intersection.
* Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */

package git.leetCode.dataStructure14Days;

public class IntersectionOfTwoArrays_II {
    public static void main(String[] args) {
        intersect(new int[]{1,2,3,2},new int[]{2,4,2}); //[2,2]
        intersect(new int[]{4,9,5},new int[]{9,4,9,8,4}); //[4,9]

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int minSize;
        if(nums1.length < nums2.length) {
            minSize = nums1.length;
        }else {
            minSize = nums2.length;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int[] commonArray = new int[minSize];
        int[] vArray = new int[nums2.length];
        int len = 0;
        for(int i=0 ; i<commonArray.length ; i++) {
            for(int j=0 ; j<vArray.length ; j++) {
                if(nums1[i] == nums2[j] && vArray[j] == 0) {
                    commonArray[i] = nums1[i];
                    len += 1;
                    vArray[j] = 1;
                    break;
                }
            }
        }
        int[] res = new int[len];
        int j=0;
        for(int i=0 ; i<commonArray.length ; i++) {
            if(commonArray[i] != 0)
                res[j++] = commonArray[i];
        }

        return res;
    }
}
