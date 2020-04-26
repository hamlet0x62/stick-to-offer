package coding.interview.sortLinkedList;

import java.util.*;

import static java.lang.System.out;

class Solution {

      static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode hi = head;

        while (hi.next != null){
            hi = hi.next;
        }

        return sort(head, hi);
    }

    ListNode mergeList(ListNode l1, ListNode l2){

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                tail.next = l2;
                l2 = l2.next;
            }else {
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
        }

        while (l1 != null){
            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
        }


        while (l2 != null){
            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
        }
        tail.next = null;

        return head.next;
    }

    public ListNode sort(ListNode lo, ListNode hi){
        if (lo == hi){
            return lo;
        }

        ListNode mid = lo;
        ListNode tmp = lo;

        while(tmp != hi){
            tmp = tmp.next;
            if(tmp != hi){
                mid = mid.next;
                tmp = tmp.next;
            }
        }
        ListNode midNext = mid.next;
        // 将原来的链表分割
        // 以便后续的合并
        mid.next = null;
        hi.next = null;
        ListNode leftHalf = sort(lo, mid);
        ListNode rightHalf = sort(midNext, hi);
        return mergeList(leftHalf, rightHalf);

    }

    static ListNode createList(int[] nums){
          ListNode head = new ListNode(-1);
          ListNode curr = head;

          for(int i=0;i<nums.length;i++){
              curr.next = new ListNode(nums[i]);
              curr = curr.next;
          }
          return head.next;
    }

    static void printList(ListNode head){
          ListNode curr = head;

          while(curr != null){
              out.print(curr.val);
              curr = curr.next;
          }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = createList(new int[] {});
        printList(head);
        ListNode sorted = s.sortList(head);
        printList(sorted);

    }
}
