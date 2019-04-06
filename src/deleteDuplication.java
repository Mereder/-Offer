public class deleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) return  null;
        if (pHead != null && pHead.next == null) return pHead;

        ListNode temp = new ListNode(-1);
        temp.next = pHead;
        ListNode tail = temp;
        ListNode p = pHead;
        while (p!= null && p.next != null){
            if (p.val == p.next.val){
                int value = p.val;
                while (p != null && value == p.next.val){
                    p = p.next;
                }
                tail.next = p;
            }
            else {
                tail = p;
                p = p.next;
            }
        }
        return temp.next;
    }
}
