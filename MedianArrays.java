class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length, i = 0, j = 0, k = 0;
        int[] nums = new int[length1 + length2];
        double median;
        
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) 
                nums[k++] = nums1[i++];
            else
                nums[k++] = nums2[j++];
        }
        
        while (i < length1)
            nums[k++] = nums1[i++];
        
        while (j < length2)
            nums[k++] = nums2[j++];
        
        if (nums.length % 2 == 0) 
            median = ( (double) nums[ nums.length/2 ] + (double) nums[ nums.length/2 - 1 ] ) / 2;
        else
            median = (double) nums[ nums.length/2 ];
        
        return median;
        
    }
}