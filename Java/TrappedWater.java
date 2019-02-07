/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
    public int trap(int[] height) {
        
        if (height == null || height.length <= 1){
            return 0;
        }
        
        int len = height.length;
        int[] rightBound = new int[len], leftBound = new int[len];
        int maxRight = 0, maxLeft = 0, waterLevel = 0;
        
        for (int i=0; i<len; i++) {
            
            if (height[i] > maxLeft) 
                maxLeft = height[i];
            
            if (height[len-i-1] > maxRight)
                maxRight = height[len-i-1];
            
            leftBound[i] = maxLeft;
            rightBound[len-i-1] = maxRight;
            
        }
        
        for (int i=1; i<len-1; i++) {
            
            if (Math.min(leftBound[i], rightBound[i]) - height[i] > 0)
                waterLevel += Math.min(leftBound[i], rightBound[i]) - height[i];
            
        }
        
        return waterLevel;
        
    }
}