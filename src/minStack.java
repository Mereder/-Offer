import java.util.Stack;

public class minStack {
    Stack<Integer> stack;
    Stack<Integer> minS;
    public int min;

    public minStack() {
        this.stack = new Stack<>();
        this.minS = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int node) {
        if (node < min){
            minS.push(node);
            min = node;
        }
        else {
            minS.push(min);
        }
        stack.push(node);
    }

    public void pop() {
        if (!stack.isEmpty() && !minS.isEmpty()) {
            if (stack.peek() == min) {
                stack.pop();
                minS.pop();
                min = minS.peek();
            } else {
                stack.pop();
                minS.pop();
            }
        }
        else throw new IllegalArgumentException("stack is empty");
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int min() {
        if (minS.isEmpty()){
            throw new IllegalStateException("111");
        }
        return minS.peek();
    }
}
