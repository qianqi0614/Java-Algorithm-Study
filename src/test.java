public class test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode res = removeNthFromEnd(l1,1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        int len = 0;
        while (first != null) {
            len ++;
            first = first.next;
        }
        len -= n;
        while (len != 0) {
            len--;
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return dummy.next;
    }
}