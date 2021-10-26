package org.snailgary;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *  寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int sum = m + n;
        int media = sum / 2;

        int[] sumArrays = new int[m + n];
        System.arraycopy(nums1, 0, sumArrays, 0, m);
        System.arraycopy(nums2, 0, sumArrays, m, n);
        Arrays.sort(sumArrays);
        if (sum % 2 == 0) {
            int medianNumLeft = media - 1;
            int medianRight = media;
            return (double) (sumArrays[medianNumLeft] + sumArrays[medianRight])/2;
        }else {
            return (double) sumArrays[media];
        }
    }

//    int nums1First = nums1[0];
//    int nums2First = nums2[0];
//
//    int[] numsLeft = nums1;
//    int[] numsRight = nums2;
//
//        if (nums1First > nums2First) {
//        numsLeft = nums2;
//        numsRight = nums1;
//    }
//
//        for (int i = 0; i < numsLeft.length; i++) {
//
//
//
//    }

    @Test
    public void test() {
        int[] nums1 = {1,3};
        int[] nums2 = {2};



    }

}
