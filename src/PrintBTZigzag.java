import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintBTZigzag {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return  result;
        Stack<TreeNode>[] stacks = new Stack[2];
        int current = 0;
        int next = 1;
        // 这个地方有问题  不能创建 stack 的数组
        stacks[current].push(pRoot);
        ArrayList<Integer> temp = new ArrayList<>();
        while(!stacks[current].isEmpty() || !stacks[next].isEmpty()){
            TreeNode p = stacks[current].pop();
            temp.add(p.val);
            if (current == 0){
                if (p.left!=null) stacks[next].push(p.left);
                if (p.right!= null) stacks[next].push(p.right);
            }
            else {
                if (p.right!=null) stacks[next].push(p.right);
                if (p.left!=null) stacks[next].push(p.left);
            }
            if (stacks[current].isEmpty()){
                result.add(temp);
                temp = new ArrayList<>();
                current = next;
                next = 1-next;
            }
        }
        return  result;
    }

    // 队列形式  技巧有两点：
    //  1. 加入ArrayList时，选择头加入 或 尾加入
    //  2. queue.size 实际上获取的是一层的结点。
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return  result;
        // 双端队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int row = 1;
        ArrayList<Integer> temp ;
        while(!queue.isEmpty()){
            // trick1
            int size = queue.size();
            temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 去掉第一个元素
                TreeNode p = queue.poll();
                if (p.left!= null)
                    queue.offer(p.left);
                if (p.right!=null)
                    queue.offer(p.right);
                // trick 2
                if (row%2==0){
                    temp.add(0,p.val);
                }
                else {
                    temp.add(p.val);
                }
            }
            row++;
            result.add(temp);
        }
        return result;
    }
    // 双栈的形式
    public ArrayList<ArrayList<Integer>> Print2(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            if (stack1.isEmpty()){
                while(!stack2.isEmpty()) {
                    TreeNode p = stack2.pop();
                    temp.add(p.val);
                    if (p.right != null) stack1.push(p.right);
                    if (p.left != null) stack1.push(p.left);
                }
            }
            else if (stack2.isEmpty()){
                while(!stack1.isEmpty()) {
                    TreeNode p = stack1.pop();
                    temp.add(p.val);
                    if (p.left != null) stack2.push(p.left);
                    if (p.right != null) stack2.push(p.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
    public static void main(String[] args) {
        LinkedList<TreeNode> test = new LinkedList<>();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        Print(one);
    }
}
