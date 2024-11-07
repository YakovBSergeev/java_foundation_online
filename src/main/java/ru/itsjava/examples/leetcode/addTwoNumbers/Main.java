package ru.itsjava.examples.listNode;

public class Main {
    public static void main(String[] args) {
        ListNode listNode01 = new ListNode( 1, new ListNode( 2, new ListNode( 3 ) ) );
        ListNode listNode02 = new ListNode( 1, new ListNode( 2, new ListNode( 3 ) ) );
        Solution listNode = new Solution();
        System.out.println( listNode.addTwoNumbers( listNode01, listNode02 ) );
    }
}
