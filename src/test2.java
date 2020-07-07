import java.util.Stack;

public class test2 {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element) {
        mainStack.push(element);
        if (minStack.empty() || minStack.peek() > element) {
            minStack.push(element);
        }
    }

    public int pop() {
        if (minStack.peek().equals(mainStack.peek())) {
            return minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception {
        if (minStack.empty()) {
            throw new Exception("stack is empty");
        }
        return minStack.pop();
    }

    public static void main(String[] args) throws Exception {
        test2 stack = new test2();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(7);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
