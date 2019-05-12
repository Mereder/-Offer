public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null) return null;
        if (isLoop(pHead)){
            ListNode slow = pHead.next;
            ListNode fast = pHead.next.next;

            while(slow != fast){
                slow = slow.next;
                fast = fast.next.next;
            }
            // 循环结束时候  slow == fast
            slow = pHead;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        else  return null;
    }
    public boolean isLoop(ListNode pHead){
        if (pHead.next == null) return false;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
