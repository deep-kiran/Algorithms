/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Vertical {
    class Node{
    TreeNode root;
    int vd;
    int hd;
    public Node(TreeNode root,int hd, int vd){
        this.root=root;
        this.vd =vd;
        this.hd =hd;
      }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>l =new ArrayList<>();
        if(root==null)return l;
        HashMap<Integer,List<Node>> mp =new HashMap<>();
        Queue<Node> q =new LinkedList<>();
        q.add(new Node(root,0,0));
        int minhd=0;
        int maxhd=0;
        while(!q.isEmpty()){
            Node curr =q.poll();
            if(!mp.containsKey(curr.hd))mp.put(curr.hd, new ArrayList<>());
            mp.get(curr.hd).add(curr);
            minhd =Math.min(minhd, curr.hd);
            maxhd =Math.max(maxhd, curr.hd);
            if(curr.root.left!=null){
                q.add(new Node(curr.root.left, curr.hd-1,curr.vd+1));
            }
            if(curr.root.right!=null){
                q.add(new Node(curr.root.right, curr.hd+1,curr.vd+1));
            }
        }
        int ind=0;
        for(int i=minhd;i<=maxhd;i++){
            Collections.sort(mp.get(i),(a,b)->{
            if(a.vd==b.vd){
                return a.root.val -b.root.val; //important
            }else{
                return a.vd-b.vd;
            }});
            l.add(new ArrayList<>());
            for(Node node: mp.get(i)){
                l.get(ind).add(node.root.val);
            }
            ind++;
        }
        return l;
    }
}
