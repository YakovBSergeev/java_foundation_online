package ru.itsjava.examples.leetcode.linkedListCycleII;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode( 3, new ListNode( 2, new ListNode( 0, new ListNode( -4 ) ) ) );
        System.out.println( Solution.detectCycle( listNode ) );
    }
}
