import java.util.List;

public class FindKthToTail {
    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int value){
            this.val = value;
        }
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null){
            fast = fast.next;
            k--;
            if (k == 0 ){
                break;
            }
        }
        if (k > 0 )return null;

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode headd = new ListNode(1);
        headd.next = new ListNode(2);
        headd.next.next = new ListNode(3);
        headd.next.next.next = new ListNode(4);
        headd.next.next.next.next = new ListNode(5);
        // headd.next.next.next.next.next = new ListNode(6);
        System.out.println(FindKthToTail(headd,6).val);
    }
}
