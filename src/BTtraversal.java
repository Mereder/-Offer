
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTtraversal {
    public static class TreeNode{
        int val;
        TreeNode left  = null;
        TreeNode right = null;
        public TreeNode(int values){
            this.val = values;
        }
    }
    //  递归 前序
    public static void preOrder(TreeNode root){
        if (root == null) return;
        else {
            System.out.print(root.val + "  ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    // 迭代 前序
    public static void Iteration_preOrder(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.val + "  ");
            if (temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }
    // 递归 中序
    public static void inOreder(TreeNode root){
        if (root == null ) return;
        else {
            inOreder(root.left);
            System.out.print(root.val + "  ");
            inOreder(root.right);
        }
    }
    // 迭代 中序
    public static void Iteration_inOrder(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else {
                temp = stack.pop();
                System.out.print(temp.val + "  ");
                temp = temp.right;
            }
        }
    }
    // 递归 后序
    public  static  void postOrder(TreeNode root){
        if(root == null ) return;
        else {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + "  ");
        }
        // System.out.println();
    }
    // 迭代  后序
    public static void Iteration_postOrder1(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;
        stack.push(root);
        while (!stack.isEmpty()){
            temp = stack.peek();
            if (temp.left == null && temp.right ==null){
                System.out.print(temp.val + "  ");
                stack.pop();
            }
            else {
                if (temp.right != null){
                    stack.push(temp.right);
                    temp.right = null;
                }
                if (temp.left != null){
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
    }
    // 迭代  后序
    public static void Iteration_postOrder(TreeNode root){
        if (root==null) {
            return;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(root);
        TreeNode temp=root;
        while(!stack1.isEmpty()){
            TreeNode tr=stack1.pop();
            stack2.push(tr);
            if (tr.left!=null) {
                stack1.push(tr.left);
            }
            if (tr.right!=null) {
                stack1.push(tr.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val+"  ");
        }
    }

    // Level traversal
    public static void levelTraversal(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.val+"  ");
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
    }




    public static TreeNode craeteTree(){
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        return A;
    }

    public static void main(String[] args) {
        TreeNode root = craeteTree();
        // preorder
        System.out.println("recursion Preorder:");
        preOrder(root);
        System.out.println();
        // Iteration preOrder
        System.out.println("Iteration preOrder");
        Iteration_preOrder(root);
        System.out.println();
        // inOreder
        System.out.println("recursion inOreder");
        inOreder(root);
        System.out.println();
        // Iteration inOreder
        System.out.println("iteration inOreder");
        Iteration_inOrder(root);
        System.out.println();
        // postOrder
        System.out.println("recursion postOrder");
        postOrder(root);
        System.out.println();
        // Iteration postOrder
        System.out.println("Iteration postOrder");
        Iteration_postOrder(root);
        System.out.println();
        // level traversal
        System.out.println("Level traversal");
        levelTraversal(root);
        System.out.println();

    }
}
