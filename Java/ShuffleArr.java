/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

class Solution {
    
    private int[] intArr;
    private int[] orig;
    
    private Random rand = new Random();

    public Solution(int[] nums) {
        this.intArr = nums;
        this.orig = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        intArr = orig;
        orig = orig.clone();
        return intArr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        List<Integer> list =  new ArrayList<Integer>();
        
        for (int i=0; i<intArr.length; i++) {
            list.add(intArr[i]);
        }
        
        for (int j=0; j<intArr.length; j++) {
            
            int remove = rand.nextInt(list.size());
            intArr[j] = list.get(remove);
            list.remove(remove);
            
        }
        
        return intArr;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */