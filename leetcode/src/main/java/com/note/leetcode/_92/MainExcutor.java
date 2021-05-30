package com.note.leetcode._92;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 1->2->3->4->5
 * 转换成
 * 5->4->3->2->1
 * @author jzue
 * @date 2021/5/25 4:41 下午
 **/
public class MainExcutor {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        createLink(head,1);
        solution3(head);
    }
    public static void solution1(ListNode head){
        Solution1 solution1 = new Solution1();
        ListNode listNode = solution1.reverseList(head);
        System.out.println(listNode);
    }
    public static void solution2(ListNode head){
        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.reverseList(head);
        System.out.println(listNode);
    }

    public static void solution3(ListNode head){
        Solution3 solution = new Solution3();
        ListNode listNode = solution.reverseList(head);
        System.out.println(listNode);
    }

    private static void createLink(ListNode listNode,int i){
        if (i<6){
            listNode.val = i;
            ListNode newNode = null;
            if (i<5){
                newNode = new ListNode();
                listNode.next = newNode;
            }

            createLink(newNode,i+1);
        }
    }
}
