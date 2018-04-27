import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

public class Merge_k_Sorted_Lists {
    //ac了,但速度很慢，依次比较每个链表的头结点，选出最小的，然后向后移一位，继续比较
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }
        ListNode temp=new ListNode(Integer.MAX_VALUE);
        boolean isNull=true;
        int j=0;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                isNull=false;
                if(temp.val>lists[i].val){
                    temp=lists[i];
                    j=i;
                }
            }
        }
        if(lists[j]!=null) {
            lists[j] = lists[j].next;
        }
        if(isNull){
            return null;
        }else{
            temp.next=mergeKLists(lists);
            return temp;
        }
    }

    //基于优先队列的排序，原理其实和自己写的差不多，只是把比较交给了优先队列来做
    public ListNode mergeKLists1(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    //借助mergeTwoList，进行length-1次合并
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }
        ListNode result=mergeTwoLists(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++){
            result=mergeTwoLists(result,lists[i]);
        }
        return result;
    }

    //借助mergeTwoList，两两合并
    public ListNode mergeKLists3(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }
        if(lists.length==2){
            return mergeTwoLists(lists[0],lists[1]);
        }else{
            if(lists.length%2==0){
                ListNode[] newList=new ListNode[lists.length/2];
                for(int i=0;i<lists.length;i=i+2){
                    newList[i/2]=mergeTwoLists(lists[i],lists[i+1]);
                }
                return mergeKLists(newList);
            }else{
                ListNode[] newList=new ListNode[lists.length/2+1];
                for(int i=0;i<lists.length-1;i=i+2){
                    newList[i/2]=mergeTwoLists(lists[i],lists[i+1]);
                }
                newList[lists.length/2]=lists[lists.length-1];
                return mergeKLists(newList);
            }
        }
    }

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
}
