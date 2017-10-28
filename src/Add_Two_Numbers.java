/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class Add_Two_Numbers {
    //TODO
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode first=l1;
//        int carry=0;
//        while(l1!=null&&l2!=null){
//            l1.val+=l2.val;
//            l1.val+=carry;
//            if(l1.val>=10){
//                l1.val-=10;
//                carry=1;
//            }
//            else{
//                carry=0;
//            }
//            l1=l1.next;
//            l2=l2.next;
//        }
//        if(l1==null&&l2!=null){
//            l1=l2;
//            System.out.println("a");
//
//        }
//        while(carry==1&&l1!=null){
//            l1.val+=carry;
//            if(l1.val>=10){
//                l1.val-=10;
//                carry=1;
//            }
//            else{
//                carry=0;
//            }
//            l1=l1.next;
//            System.out.println("b");
//        }
//        if(l1==null&&carry==1){
//            l1=new ListNode(carry);
//            System.out.println("c");
//        }
//        return first;
//    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
