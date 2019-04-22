public class FindFirstCommonNode {
    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        ListNode p = pHead1;
        int n1= 0;
        while(p != null){
            p = p.next;
            n1++;
        }
        int n2 = 0;
        ListNode p2 = pHead2;
        while(p2 != null){
            p2 = p2.next;
            n2++;
        }
        int error = Math.abs(n1-n2);
        p = pHead1;
        p2 = pHead2;
        if (n1 >= n2){
            while(p != null && error > 0){
                p = p.next;
                error--;
            }
        }
        else {
            while(p2 != null && error > 0){
                p2 = p2.next;
                error--;
            }
        }
        while(p != null && p2 != null){
            if (p == p2) return p;
            p = p.next;
            p2 = p2.next;
        }
        if (p == null) return null;
        if (p2 == null) return null;
        return null;
    }
}
