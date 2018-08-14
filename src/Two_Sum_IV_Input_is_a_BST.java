import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Two_Sum_IV_Input_is_a_BST {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        HashSet<Integer> set=new HashSet<>();
        set.add(root.val);
        return find(root,k,set);
    }

    private boolean find(TreeNode node, int k, HashSet<Integer> set){
        if(node==null){
            return false;
        }
        if(set.contains(k-node.val)&&k-node.val!=node.val){
            return true;
        }
        if(node.left!=null){
            set.add(node.left.val);

        }
        if(node.right!=null){
            set.add(node.right.val);
        }
        return find(node.left,k,set)||find(node.right,k,set);

    }


//    public boolean findTarget(TreeNode root, int k) {
//        Set< Integer > set = new HashSet();
//        return find(root, k, set);
//    }
//    public boolean find(TreeNode root, int k, Set < Integer > set) {
//        if (root == null)
//            return false;
//        if (set.contains(k - root.val))
//            return true;
//        set.add(root.val);
//        return find(root.left, k, set) || find(root.right, k, set);
//    }

//    Using BFS and HashSet [Accepted]
//    public boolean findTarget(TreeNode root, int k) {
//        Set < Integer > set = new HashSet();
//        Queue< TreeNode > queue = new LinkedList();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            if (queue.peek() != null) {
//                TreeNode node = queue.remove();
//                if (set.contains(k - node.val))
//                    return true;
//                set.add(node.val);
//                queue.add(node.right);
//                queue.add(node.left);
//            } else
//                queue.remove();
//        }
//        return false;
//    }

    //先按广度优先排序成一个列表，然后寻找是否有符合条件的数字对
//    public boolean findTarget(TreeNode root, int k) {
//        List < Integer > list = new ArrayList();
//        inorder(root, list);
//        int l = 0, r = list.size() - 1;
//        while (l < r) {
//            int sum = list.get(l) + list.get(r);
//            if (sum == k)
//                return true;
//            if (sum < k)
//                l++;
//            else
//                r--;
//        }
//        return false;
//    }
//    public void inorder(TreeNode root, List < Integer > list) {
//        if (root == null)
//            return;
//        inorder(root.left, list);
//        list.add(root.val);
//        inorder(root.right, list);
//    }
}
