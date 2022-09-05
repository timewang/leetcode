package org.snailgary;

import lombok.ToString;

/**
 * Created by wangzhongfu on 2022/9/2
 */
@ToString
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
