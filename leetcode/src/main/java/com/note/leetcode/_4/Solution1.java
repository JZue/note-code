package com.note.leetcode._4;

public class Solution1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int cursor1=0;
        int cursor2=0;
        int res = 0;
        int current=0;
        int half = length/2;
        int length1=nums1.length;
        int length2=nums2.length;
        for (int i = 0;i<length;i++){


            if (cursor1<length1&&cursor2<length2){
                if (nums1[cursor1]<nums2[cursor2]){
                    current= nums1[cursor1];
                    cursor1++;

                }else {
                    current= nums2[cursor2];
                    cursor2++;
                }
            }else {
                if (cursor1 == length1&&cursor2!=length2){
                    current= nums2[cursor2];
                    cursor2++;

                }
                if (cursor2 == length2&&cursor1!=length1) {
                    current= nums1[cursor1];
                    cursor1++;

                }
            }

            if (length%2 == 0){
                if ( cursor1+cursor2 == half){
                    res += current;
                }
                if ( cursor1+cursor2 == half+1){
                    res += current;
                    return ((double) res)/2;
                }
            }else {
                if ( cursor1+cursor2 == length/2+1){
                    res += current;
                    return (double) res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums11 = {2};
        Solution1 solution1 = new Solution1();
        double medianSortedArrays1 = solution1.findMedianSortedArrays(nums1, nums11);
        System.out.println("medianSortedArrays1"+medianSortedArrays1);
        int[] nums2 = {1,2}, nums22 = {3,4};
        double medianSortedArrays2 = solution1.findMedianSortedArrays(nums2, nums22);
        System.out.println("medianSortedArrays2"+medianSortedArrays2);
        int[] nums3 = {0,0}, nums33 = {0,0};
        double medianSortedArrays3 = solution1.findMedianSortedArrays(nums3, nums33);
        System.out.println("medianSortedArrays3"+medianSortedArrays3);

        int[] nums4 = {}, nums44 = {1};
        double medianSortedArrays4 = solution1.findMedianSortedArrays(nums4, nums44);
        System.out.println("medianSortedArrays4"+medianSortedArrays3);
    }
}
