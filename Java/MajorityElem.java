/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //nums element is key and size as value
        int max = 0;
        int maxElem = 0;
        
        for (int i=0; i<nums.length; i++) { //Iterate through arr, add to hashmap, if it is already in the map, increment value
            
            if (map.containsKey(nums[i])) 
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
            
        }
        
        for (Integer i : map.keySet()) {//Find the maximum size and store its key
            
            if (map.get(i) > max) {
                
                max = map.get(i);
                maxElem = i;
                
            }
            
        }
        
        return maxElem;
    }
}