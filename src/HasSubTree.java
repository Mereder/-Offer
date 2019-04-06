public class HasSubTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        if (root1 == null) return false;
        if (root2 == null) return false;
        // 总体上是 先序列遍历
        return isSubtree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean isSubtree(TreeNode root1,TreeNode root2){
        // root2 是子结构。
        if (root2 == null ) return true;
        // root2 != null  && roo1 == null
        if (root1 == null ) return false;
        if (root1.val == root2.val){
            return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
        }
        return false;
    }
}
