package ru.itsjava.examples.leetcode.addTwoNumbers;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ListNode listNode01 = new ListNode( 2, new ListNode( 4, new ListNode( 3 ) ) );
        ListNode listNode02 = new ListNode( 5, new ListNode( 6, new ListNode( 4 ) ) );
        Solution listNode = new Solution();

        System.out.println( listNode.addTwoNumbers( listNode01, listNode02 ) );
    }
}
