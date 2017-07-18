/**
 * Created by xjwhhh on 2017/7/14.
 */

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead = head;
        //newhead!=null,注意链表为空的情况
        while (newhead != null && newhead.next != null) {
            if (newhead.val == newhead.next.val) {
                newhead.next = newhead.next.next;
            } else {
                newhead = newhead.next;
            }
        }
        return head;
    }
}
