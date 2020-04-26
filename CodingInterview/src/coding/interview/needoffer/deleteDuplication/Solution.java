package coding.interview.needoffer.deleteDuplication;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode insertAfter(int nodeVal){
            ListNode curr = new ListNode(nodeVal);
            ListNode next = this.next;
            this.next = curr;
            curr.next = next;

            return curr;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {

        if(pHead == null){
            return null;
        }

        ListNode head = new ListNode(pHead.val-1);
        head.next = pHead;
        ListNode curr = pHead, prev = head, next = pHead.next;

        while(curr != null && next != null){
            if(curr.val == next.val){
                while(next != null && curr.val == next.val){
                    curr.next = next.next;
                    next.next = null;
                    next = curr.next;
                }
                // 已经遍历到链表尽头
                prev.next = next;
                curr = next;
                if(curr != null){
                    next = curr.next;
                }
            }else {
                // 当前的curr与next的值不相等
                // 向前移动一步
                prev = curr;
                curr = next;
                next = next.next;
            }
        }

        return head.next;
    }

    static ListNode insert(ListNode prev, ListNode curr){
        ListNode next = prev.next;
        prev.next = curr;
        curr.next = next;

        return curr;
    }

    static void printNodes(ListNode curr){
        while(curr != null){
            out.print(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // test method
        Solution s = new Solution();

        ListNode head = new ListNode(1);

        head.insertAfter(1).insertAfter(3).insertAfter(3).insertAfter(4).insertAfter(4).insertAfter(5);
        ListNode rst = s.deleteDuplication(head);
        printNodes(rst);
    }

}
