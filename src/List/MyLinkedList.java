package List;

public class MyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node last;
    private int size;

    /**
     * 链表插入元素
     * @param data 插入元素
     * @param index 插入位置
     * @throws Exception
     */
    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入位置超出链表节点范围！");
        }
        Node insertedNode = new Node(data);
        if (size == 0) {
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else if (index == size) {
            last.next = insertedNode;
            last = insertedNode;
        } else {
            Node prevNode = get(index - 1);
//            Node nextNode = prevNode.next;
//            prevNode.next = insertedNode;
//            insertedNode.next = nextNode;
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     * @param index 删除元素的位置
     * @throws Exception
     */
    public void remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("删除元素超出链表节点范围！");
        }
        Node removeNode = null;
        if (index == 0) {
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            Node prevNode = get(index - 1);
            removeNode = last;
            prevNode.next = null;
            last = prevNode;
        } else {
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = removeNode.next;
        }
        size--;
        System.out.println(index + "位置内容为" + removeNode.data + "的节点已经删除！");
    }

    /**
     * 链表查找元素
     * @param index 查找元素的位置
     * @return 元素节点
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("该元素超出链表节点范围！");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(1,0);
        myLinkedList.insert(2,1);
        myLinkedList.insert(3,2);
        myLinkedList.insert(2,2);
        myLinkedList.output();
        System.out.println("----------");
        myLinkedList.remove(0);
        myLinkedList.output();
    }


}
