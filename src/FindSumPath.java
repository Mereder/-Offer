import java.util.ArrayList;

public class FindSumPath {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    public ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<>(list));
        if (root.left != null)
            FindPath(root.left,target);
        if (root.right != null)
            FindPath(root.right,target);
        // 不等的话 要 去掉 最后一次加入的叶节点
         list.remove(list.size()-1);
        return listAll;
    }
}
