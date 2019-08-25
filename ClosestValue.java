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
    
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> st =new Stack<>();
        long pred =Integer.MIN_VALUE;
        while(!st.isEmpty()|| root!=null){
            while(root!=null){
                st.add(root);
                root=root.left;
            }
            root=st.pop();
            if(pred <=target && target<root.val){
                return Math.abs(pred-target)<Math.abs(root.val -pred) ?(int)pred:root.val;
            }
            pred =root.val;
            root=root.right;
        }
        return (int)pred;
    }
}
