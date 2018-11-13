class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 1;
        
        Arrays.sort(nums);
        
        int last = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] >= 1) {
                
                if ((nums[i] - last) > 1) 
                    return last + 1;
                
                last = nums[i];
                
            }
        }
        return nums[nums.length-1] + 1;
    }
}
