package org.snailgary;

import java.util.StringJoiner;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp = l1;
        ListNode temp2 = l2;

        ListNode current = null;
        ListNode finalTemp = null;
        ListNode finalListNode = null;

        while (temp != null || temp2 != null) {
            //System.out.println(temp.val);
            //System.out.println(temp2.val);
            if (temp == null) {
                temp = new ListNode(0);
            }
            if (temp2 == null) {
                temp2 = new ListNode(0);
            }
            int result = temp.val + temp2.val;

            if (current != null) {
                result = result + 1;
                current = null;
            }

            if (finalListNode == null) {
                ListNode listNode6 = null;
                if (result >= 10) {
                    listNode6 = new ListNode(result - 10);
                } else {
                    listNode6 = new ListNode(result);
                }
                finalListNode = listNode6;
                finalTemp = listNode6;
            } else {
                if (result >= 10) {
                    finalListNode.next = new ListNode(result - 10);
                } else {
                    finalListNode.next = new ListNode(result);
                }
                finalListNode = finalListNode.next;
            }
            if (result >= 10) {
                current = new ListNode(1);
            }

            if (temp.next != null) {
                temp = temp.next;
            }else {
                temp = null;
            }
            if (temp2.next != null) {
                temp2 = temp2.next;
            }else {
                temp2 = null;
            }

            if (temp == null && temp2 == null && current != null) {
                temp = new ListNode(0);
            }

        }


        return finalTemp;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("next=" + next)
                    .toString();
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;


        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(4);

        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode temp = listNode;
        ListNode temp2 = listNode3;

        ListNode current = null;
        ListNode finalTemp = null;
        ListNode finalListNode = null;

        while (true) {
            //System.out.println(temp.val);
            //System.out.println(temp2.val);
            int result = temp.val + temp2.val;

            if (current != null) {
                result = result + 1;
                current = null;
            }

            if (finalListNode == null) {
                ListNode listNode6 = null;
                if (result > 10) {
                    listNode6 = new ListNode(result - 10);
                } else {
                    listNode6 = new ListNode(result);
                }
                finalListNode = listNode6;
                finalTemp = listNode6;
            } else {
                if (result >= 10) {
                    finalListNode.next = new ListNode(result - 10);
                } else {
                    finalListNode.next = new ListNode(result);
                }
                finalListNode = finalListNode.next;
            }
            if (result >= 10) {
                current = new ListNode(1);
            }


            if (temp.next == null) {
                break;
            }

            temp = temp.next;
            temp2 = temp2.next;
        }

        System.out.println(finalTemp);
    }

}
