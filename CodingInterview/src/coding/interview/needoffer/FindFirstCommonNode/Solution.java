package coding.interview.needoffer.FindFirstCommonNode;

public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    int getLength(ListNode head){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }

        return count;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        int n1 = getLength(pHead1);
        int n2 = getLength(pHead2);

        ListNode cur1 = pHead1, cur2 = pHead2;

        if(n1 > n2){
            while(n1 > n2 && cur1 != null){
                cur1 = cur1.next;
            }
        }else {
            while(n2 > n1 && cur2 != null){
                cur2 = cur2.next;
            }
        }
        while(cur1 != null && cur2 != null){

            if(cur1 == cur2){
                return cur1;
            }else {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return null;
    }
}
