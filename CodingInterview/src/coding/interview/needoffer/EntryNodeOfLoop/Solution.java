package coding.interview.needoffer.EntryNodeOfLoop;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

     public ListNode EntryNodeOfLoop(ListNode pHead) {
         ListNode fast = pHead, slow = pHead;
         while(fast != null && slow != null){
             if(fast.next == null){
                 return null;
             }else {

                 if (fast == slow){
                     // fast 与 low 在环上相遇
                     ListNode tmp = pHead;
                     while(tmp != slow){
                         slow = slow.next;
                         tmp = tmp.next;
                     }
                     return tmp;
                 }

                 slow = slow.next;
                 fast = fast.next.next;
             }
         }

         return null;

    }


    public static void main(String[] args) {
        // test method
    }

}
