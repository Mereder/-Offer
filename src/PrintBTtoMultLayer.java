import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintBTtoMultLayer {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static  ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int numOfcurrent = 1;
        int numOfnext = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            // 默认remove 第一个元素
            TreeNode p = queue.remove();
            temp.add(p.val);
            numOfcurrent--;
            if (p.left != null){
                queue.add(p.left);
                numOfnext++;
            }
            if (p.right != null){
                queue.add(p.right);
                numOfnext++;
            }
            if (numOfcurrent == 0){
                numOfcurrent = numOfnext;
                numOfnext = 0;
                result.add(temp);
                temp = new ArrayList<>();
            }
        }
        return result;
    }

    // 只输出的版本
    public static void Print1(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null)
            throw new IllegalArgumentException("error ");
        queue.add(root);
        int current = 1;
        int next = 0;
        while(! queue.isEmpty()){
            TreeNode p = queue.remove();
            System.out.printf("%d \t",p.val);
            current--;
            if (p.left != null){
                queue.add(p.left);
                next++;
            }
            if (p.right!=null){
                queue.add(p.right);
                next++;
            }
            if (current == 0){
                current = next;
                next = 0;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // LinkList remove 默认remove 第一个
        LinkedList<TreeNode> test = new LinkedList<>();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        Print1(one);


    }
}
