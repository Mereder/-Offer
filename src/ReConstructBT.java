
public class ReConstructBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre != null && in!= null) {
            TreeNode treeNode = reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
            return treeNode;
        }
        return null;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int preS, int preE, int inS, int inE) {
        if (preS > preE || inS > inE ) return null;
        TreeNode root = new TreeNode(pre[preS]);

        for (int i = inS; i <= inE; i++) {
            if (in[i] == pre[preS]){
                root.left = reConstructBinaryTree(pre,in,preS+1,preS+i-inS,inS,i-1);
                root.right = reConstructBinaryTree(pre,in,preS+i+1-inS,preE,i+1,inE);
                break;
            }
        }
        return root;
    }
}
