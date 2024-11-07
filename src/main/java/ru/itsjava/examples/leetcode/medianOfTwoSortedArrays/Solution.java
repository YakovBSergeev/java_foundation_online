package ru.itsjava.examples.leetcode.medianOfTwoSortedArrays;

import java.util.Arrays;

public class Solution {
    public double findMedianSortedArrays01(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream( nums1 ).sum();
        int sum2 = Arrays.stream( nums2 ).sum();
        return (double) (sum1 + sum2) / (nums1.length + nums2.length);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sum = new int[nums1.length + nums2.length];
        System.arraycopy( nums1, 0, sum, 0, nums1.length );
        System.arraycopy( nums2, 0, sum, nums1.length, nums2.length );
        Arrays.sort( sum );
        System.out.println( Arrays.toString( sum ) );
        if (sum.length == 0) {
            return 0;
        } else if (sum.length == 1) {
            return sum[0];
        } else if (sum.length % 2 == 1) {
            return sum[(sum.length - 1) / 2];
        } else {
            return (double) (sum[sum.length / 2 - 1] + sum[sum.length / 2]) / 2;
        }
    }

    public static double findMedianSortedArraysBinary(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysBinary( nums2, nums1 );
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partitionA - 1];
            int minRightA = (partitionA == m)
                    ? Integer.MAX_VALUE
                    : nums1[partitionA];
            int maxLeftB = (partitionB == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partitionB - 1];
            int minRightB = (partitionB == n)
                    ? Integer.MAX_VALUE
                    : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (
                            (Math.max( maxLeftA, maxLeftB ) +
                                    Math.min( minRightA, minRightB )) /
                                    2.0
                    );
                } else {
                    return Math.max( maxLeftA, maxLeftB );
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 3, 9, 15};
        int[] n2 = {2, 7, 7};
//        System.out.println( findMedianSortedArrays( n1, n2 ) );
        System.out.println( findMedianSortedArraysBinary( n1, n2 ) );

    }

}
