/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
      ListNode left=head;
      ListNode mid=head.next;
      ListNode right=head.next.next;  
      int first=-1;
      int last=-1;
      int[] ans={-1,-1};
      int idx=1;
      int minDist=Integer.MAX_VALUE;
      while(right!=null){
            if(left.val> mid.val && right.val>mid.val  || left.val<mid.val && right.val<mid.val){
                if(first==-1) first=idx;
                if(last!=-1){
                    int dis=idx-last;
                    minDist=Math.min(minDist,dis);
                }
                last=idx;
            }
            idx++;
            left=left.next;
            mid=mid.next;
            right=right.next;
        }
        if(first==last) return ans;
        ans[0]=minDist;
        ans[1]=last-first;
        return ans;
    }
}