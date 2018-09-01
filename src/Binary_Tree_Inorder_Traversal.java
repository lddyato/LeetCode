import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left!=null){
            inorder(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            inorder(root.right,list);
        }
    }
}
