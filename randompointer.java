/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node curr =head;
        if(head==null )return head;
        Node temp =null;
        while(curr!=null){
            temp =curr.next;
            curr.next =new Node(curr.val);
            curr.next.next =temp;
            curr =curr.next.next;
        }
        curr =head;
        while(curr!=null){
            if(curr.next!=null){
                curr.next.random = (curr.random !=null)? curr.random.next :null;
            }
            curr =(curr.next!=null)? curr.next.next :curr.next;
        }
        Node orig =head;
        Node copy =head.next;
        temp =copy;
        while(orig!=null && copy!=null){
            orig =(orig.next!=null)? orig.next.next: orig.next;
            copy =(copy.next!=null)? copy.next.next :copy.next;
            orig =orig.next;
            copy =copy.next;
        }
        return temp;
    }
}
