## 题目描述

输入一个链表，输出该链表中倒数第k个结点。

### 解题思路

快慢指针，跟判断链表有无环相似。

fast指针先走k步，然后slow和fast指针再同时走，当fast到链表尾的时候，slow指向的就是倒数第k个。

细节问题：

1.鲁棒性：head == null  ||   k <= 0   return null

2.当链表长度小于K的时候，返回 null。当fast已经走到 null的时候，看k ！=0 如果 k>0说明  链表长度小于K 返回Null

### 题解

```java

    public static ListNode FindKthToTail(ListNode head,int k) {
        // 每个程序上来都要判断特殊
        if (head == null || k <= 0) return null;
        ListNode fast = head;
        ListNode slow = head;
        // fast 先走
        while (fast != null){
            fast = fast.next;
            k--;
            // 恰好k 步
            if (k == 0 ){
                break;
            }
        }
        // 当fast已经到链尾 k>0 ，大于链表长度
        if (k > 0 )return null;
        
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
```

