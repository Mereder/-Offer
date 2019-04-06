public class ReverseLinkList {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode ReverseList(ListNode node){
        if (node == null ) return null;
        ListNode pre = node;
        ListNode cur = node.next;
        while (cur != null){
            pre.next = cur.next;
            cur.next = node;
            node = cur;
            cur = pre.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
        head = ReverseList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
