public class RandomListNodeClone {
    public static class RandomListNode{
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        public RandomListNode(int label) {
            this.label = label;
        }
    }
    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        RandomListNode result = null;

        result = copy(pHead);

        result = Link(result);

        result = broken(result);

        return result;
    }

    public static RandomListNode copy(RandomListNode pHead){
        RandomListNode p = pHead;
        while(p != null){
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
        return pHead;
    }

    public static RandomListNode Link(RandomListNode step1){
        RandomListNode p = step1;
        while(p != null){
            if(p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        return step1;
    }

    public static RandomListNode broken(RandomListNode step2){
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tail = dummy;
        RandomListNode p = step2;
        while(p != null){
            tail.next = p.next;
            tail = tail.next;
            p = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        RandomListNode four = new RandomListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        one.random = three;
        two.random = four   ;

        RandomListNode result = Clone(one);
    }

}
