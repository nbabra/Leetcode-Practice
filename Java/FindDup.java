/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> resList = new ArrayList<Integer>();
        List<Integer> dupList = new ArrayList<Integer>();
        
        int len = nums.length;
        
        for (int i=0; i<len; i++) {
            if (dupList.contains(nums[i])) {
                resList.add(nums[i]);
            }else{
                dupList.add(nums[i]);
            }
        }
        
        return resList;
        
    }
}