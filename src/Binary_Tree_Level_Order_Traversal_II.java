import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II {
    //广度优先遍历，借助队列数据结构，由于队列是先进先出的顺序，因此可以先将左子树入队，然后再将右子树入队。
    //这样一来，左子树结点就存在队头，可以先被访问到。
    //另，广度优先遍历，可以借助堆栈的数据结构，由于堆栈是后进先出的顺序，由此可以先将右子树压栈，然后再对左子树压栈，
    //这样一来，左子树结点就存在了栈顶上，因此某结点的左子树能在它的右子树遍历之前被遍历。
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            result.add(0, subList);
        }
        return result;

    }
}
