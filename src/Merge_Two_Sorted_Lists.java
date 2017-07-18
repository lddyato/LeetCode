/**
 * Created by xjwhhh on 2017/7/14.
 */

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Merge_Two_Sorted_Lists {
    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeHead;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
    //TODO
    //另一个想法，先将两个list按顺序排为一个list，再去除新list中的重复值，调用remove_duplicates_from_sorted_list
}
