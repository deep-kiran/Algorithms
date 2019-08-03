/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> al =new ArrayList<>();
        if(root==null)return al;
        Queue<TreeNode> q =new LinkedList();
        q.add(root);
        boolean isright =false;
        while(!q.isEmpty()){
            List<Integer> l =new ArrayList<>();
            List<TreeNode> kids =new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode temp = q.poll();
                l.add(temp.val);
                if(temp.left!=null){
                    kids.add(temp.left);
                }
                if(temp.right!=null){
                    kids.add(temp.right);
                }
            }
            if(isright==true){
                Collections.reverse(l);
            }
            isright= !isright;
            al.add(l);
            for(TreeNode node: kids){
                q.add(node);
            }
        }
        return al;
    }
}
