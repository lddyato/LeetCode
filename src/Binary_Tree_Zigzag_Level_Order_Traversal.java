import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
//    //wrong
//        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        ArrayList<TreeNode> queue = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        queue.add(root);
//        int levelNum = 1;
//        while (!queue.isEmpty()) {
//            levelNum++;
//            int levelSize = queue.size();
//            List<Integer> subList = new ArrayList<>();
//            if (levelNum % 2 == 0) {
//                for (int i = 0; i < levelSize; i++) {
//                    if (queue.get(0).right != null) queue.add(queue.get(0).right);
//                    if (queue.get(0).left != null) queue.add(queue.get(0).left);
//                    subList.add(queue.get(0).val);
//                    System.out.println(queue.get(0).val);
//                    queue.remove(0);
//
//                }
//            } else {
//                for (int i = 0; i < levelSize; i++) {
//                    System.out.println(queue.size()-1);
//                    if (queue.get(queue.size()-1).left != null) queue.add(queue.get(queue.size()-1).left);
//                    if (queue.get(queue.size()-1).right != null) queue.add(queue.get(queue.size()-1).right);
//                    subList.add(queue.get(queue.size()-1).val);
//                    System.out.print(queue.get(queue.size()-1).val);
//                    queue.remove(queue.size()-1);
//                }
//            }
//            list.add(subList);
//        }
//        return list;
//    }

    //正确的思路是更改加进sublist的顺序，而不是queue的顺序
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if (order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }

}
