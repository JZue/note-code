package com.note.leetcode._92;

import java.util.Stack;

/**
 * @author jzue
 * @date 2021/5/25 5:50 下午
 **/
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null) {
            stack.push(head);
            head= head.next;
        }

        if (stack.isEmpty()) {
            return null;
        }
        ListNode newhead = stack.pop();
        ListNode curNode = newhead;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            curNode.next =temp;
            curNode = curNode.next;
        }
        // 最后一个结点是1的那个结点，它会指向2，所以必须置空
        curNode.next = null;
        return newhead;
    }
}
