import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element) {
        mainStack.push(element);
        // 如果辅助栈为空，或者新元素小于等于辅助栈栈顶，则将元素压入辅助栈
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    public Integer pop() {
        // 如果出栈元素和辅助栈栈顶元素相等，辅助栈出栈
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception {
        if (mainStack.empty()) {
            throw new Exception("stack is empty!");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
