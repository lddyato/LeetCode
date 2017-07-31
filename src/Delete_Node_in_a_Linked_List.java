/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */

public class Delete_Node_in_a_Linked_List {
    /**
     * The usual way of deleting a node node from a linked list is to modify the next pointer of the node before it, to point to the node after it.
     * Since we do not have access to the node before the one we want to delete, we cannot modify the next pointer of that node in any way. Instead, we have to replace the value of the node we want to delete with the value in the node after it, and then delete the node after it.
     * Because we know that the node we want to delete is not the tail of the list, we can guarantee that this approach is possible.
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
