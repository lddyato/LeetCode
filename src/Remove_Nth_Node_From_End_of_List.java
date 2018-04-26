public class Remove_Nth_Node_From_End_of_List {
    //可以在head之前加一个自己构造的node
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int k = n;
        while (k >= 0) {
            first = first.next;
            k--;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
