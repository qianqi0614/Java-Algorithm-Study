public class ReserveNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reserve(ListNode head) {
        ListNode curr = head;
        ListNode prev = null, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        System.out.println(node.val+","+node.next.val+","+node.next.next.val);
        ListNode res = reserve2(node);
        System.out.println(res.val+","+res.next.val+","+res.next.next.val);
    }

    public static ListNode reserve2(ListNode head) {
        ListNode curr = head;
        ListNode prev = null, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
