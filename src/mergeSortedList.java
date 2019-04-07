public class mergeSortedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null && list2 != null) return list2;
        if(list1 != null && list2 == null) return list1;
        ListNode temp = new ListNode(-1);
        ListNode p = temp;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
            else{
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }
        }
        while(list1 != null){
            p.next = list1;
            p = p.next;
            list1 = list1.next;
        }
        while(list2 != null){
            p.next = list2;
            p = p.next;
            list2 = list2.next;
        }
        return temp.next;
    }
}
