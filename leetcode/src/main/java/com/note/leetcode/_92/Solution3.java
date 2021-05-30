package com.note.leetcode._92;

/**
 * @author jzue
 * @date 2021/5/25 6:18 下午
 **/
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        ListNode pre =null;
        ListNode cur =head;
        while (cur!=null) {
            ListNode  tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur =tmp;
        }
        return  pre;
    }
}
