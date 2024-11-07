package ru.itsjava.examples.leetcode.linkedListCycleII;

import lombok.Data;


@Data

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode() {
    }

//    ListNode(int val) {
//        this.val = val;
//    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
