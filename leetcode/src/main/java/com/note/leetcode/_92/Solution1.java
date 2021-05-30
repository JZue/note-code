package com.note.leetcode._92;

/**
 *
 * 递归
 * @author jzue
 * @date 2021/5/25 1:53 下午
 **/
public class Solution1 {

    public ListNode reverseList(ListNode head) {
        return recursion(null,head);
    }
    private ListNode  recursion(ListNode pre ,ListNode node) {
        //  1-》2-》3-》null 尾结点有一个默认的空结点
        if (node == null) {
            return pre;
        }
        ListNode next = node.next;
        node.next = pre;
        return  recursion(node,next);
    }
}
