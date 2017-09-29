package com.leetcode;

/**
 * Created by jenkin on 2017-09-28.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode l;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l = l1==null?l2:l1;
        while(l1 != null && l2 != null) {
            l1.val = l1.val + l2.val;
            l2 = l2.next;
            if(l1.next==null) {
                l1.next = l2;
                l2 = null;
            } else {
                l1 = l1.next;
            }
        }
        l1 = l;
        while(l1!=null) {
            if(l1.val > 9) {
                l1.val = l1.val%10;
                if(l1.next != null) {
                    l1.next.val++;
                } else {
                    ListNode ln = new ListNode(1);
                    l1.next = ln;
                }
            }
            l1 = l1.next;
        }
        return l;
    }
}