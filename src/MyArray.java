public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入元素
     * @param element 插入元素
     * @param index 插入位置
     * @throws Exception
     */
    public void insert(int element, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("插入的位置超出数组实际元素范围！");
        }
        if (size >= array.length) {
            resize();
        }
        if (size - index >= 0) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 数组扩容
     */
    private void resize() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }

    /**
     * 输出数组
     */
    private void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
        System.out.println("---------------");
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 数组删除元素
     * @param index 删除元素的位置
     * @throws Exception
     */
    private void delete(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("删除的位置超出数组实际元素范围!");
        }
        int deleteElement = array[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
        System.out.println(index + "位置的" + deleteElement + "元素已删除！");;
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(4);
        myArray.insert(1, 0);
        myArray.insert(2, 1);
        myArray.insert(3, 2);
        myArray.insert(4, 3);
        myArray.insert(5, 4);
        myArray.insert(2, 1);
//        myArray.delete(2);
//        myArray.delete(3);
        myArray.output();
    }
}
