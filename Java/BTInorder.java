/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (root == null)
            return result;
        
        TreeNode curr = root;
        
        while (curr != null || stack.size() > 0) {
            
            while (curr != null) {
                
                stack.push(curr);
                curr = curr.left;
                
            }
            
            curr = stack.pop();
            
            result.add(curr.val);
            
            curr = curr.right;
            
        }
        
        return result;
        
    }
}