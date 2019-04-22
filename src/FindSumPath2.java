import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;

public class FindSumPath2 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 剑指 原题 解决
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> resultall = new ArrayList<>();
    public static void FindPath(TreeNode root,int target){
        if (root == null) target=target;
        result.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            System.out.println("find path");
            resultall.add(new ArrayList<>(result));
            // 迭代器写法
//            Iterator<Integer> iterList = result.iterator();
//            while (iterList.hasNext()){
//                System.out.println(iterList.next());
//            }
            // 循环写法
//            for (int i = 0; i < result.size(); i++) {
//                System.out.println(result.get(i));
//            }
            // result.clear();
        }

        if (root.left != null)
            FindPath(root.left,target);
        if (root.right != null)
            FindPath(root.right,target);

        result.remove(result.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right =  new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);


        FindPath(root,22);
        Iterator<ArrayList<Integer>> iterator = resultall.iterator();
        while(iterator.hasNext()){
            Iterator<Integer> iterator1 = iterator.next().iterator();
            while(iterator1.hasNext()){
                System.out.println(iterator1.next());
            }

        }
    }
}
