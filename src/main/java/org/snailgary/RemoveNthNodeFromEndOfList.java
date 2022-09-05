package org.snailgary;

import lombok.ToString;

/**
 * Created by wangzhongfu on 2022/9/2
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int listLength = 1;
        ListNode listNode = head.next;
        while (listNode != null) {
            listLength++;
            listNode = listNode.next;
        }
        System.out.println(listLength);
        if (listLength == 1 && n == 1) {
            return null;
        }
        if (listLength == 2 && n == 1) {
            head.next = null;
            return head;
        }
        if (listLength == 2 && n == 2) {
            return head.next;
        }
        if (n == listLength) {
            return head.next;
        }
        ListNode pre = head;
        ListNode post = null;
        for (int i = 1; i < listLength; i++) {
            if (i > 1) {
                pre = pre.next;
            }
            if (pre != null && pre.next != null) {
                post = pre.next.next;
            }
            if (i == (listLength - n)) {
                pre.next = post;
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        ListNode head3 = new ListNode(3);
        head2.next = head3;

        /*
        ListNode head4 = new ListNode(4);
        head3.next = head4;

        ListNode head5 = new ListNode(5);
        head4.next = head5;*/

        System.out.println(head);
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 3));
    }
}
