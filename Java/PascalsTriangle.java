/*

 Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

 Example:

 Input: 5
 Output:
 [
      [1],
     [1,1],
    [1,2,1],
   [1,3,3,1],
  [1,4,6,4,1]
 ]

*/

 class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] arr = new int[numRows][numRows];
        List<List<Integer>> list = new ArrayList<List<Integer>>();
      
        
        for (int i=0; i<numRows; i++) {
            List<Integer> rowList =  new ArrayList<Integer>();
            for (int j=0; j<=i; j++) {
                
                if (i == j || j==0) {
                    
                    arr[i][j] = 1;
                    
                }else{
                    
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j]; 
                    
                }
                rowList.add(arr[i][j]);
                
            }
            list.add(rowList);
        }
        return list;
    }
}