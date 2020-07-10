import java.util.Arrays;

public class MyStack {

    private int[] array;
    private int size;
    private int capacity;

    public MyStack (int capacity){
        this.capacity = capacity;
        array = new int[capacity];
        size = 0;
    }

    public void push(int element) {
        if (size >= capacity) {
            resize();
        }
        array[size++] = element;
    }

    private void resize() {
        int newSize = size * 2;
        array = Arrays.copyOf(array,newSize);
    }

    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is empty!");
        }
        return array[--size];
    }

    public static void main(String[] args) throws Exception{
        MyStack myStack = new MyStack(2);
        myStack.push(2);
        myStack.push(5);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(1);
        myStack.push(3);
        System.out.println(myStack.pop());
    }
}
