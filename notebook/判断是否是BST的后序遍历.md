## 题目描述

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。



### 题目解析

结合 [重构二叉树题目](https://www.jianshu.com/p/065a1188d2d9)

两道题基本一致，都是递归左右子树。 

难点：在于思考清楚 左右子树的入口（左子树的范围，右子树的范围）

对于一次递归中的思路是：

先从一棵树的最左侧开始，若都小于该树的root 就向右滑动，知道遇到第一个比root大的值（左子树都应该< root）

然后再从第一个大的值开始，继续向右遍历（右子树都应该>root），若出现 小于的情况 则直接判false；



### 题解

```java
public boolean VerifySquenceOfBST(int [] sequence) {
    int n = sequence.length;
    if(n <= 0 && sequence == null ) return false;
    int root = sequence[n-1];
    int i = 0;

    return helper(sequence,0,n-1,n);

}

public boolean helper(int []sequence,int lo ,int hi,int length){
    if (length <= 0 ) return  false;
    int root = sequence[hi];
    int i = lo;
    while (i < hi){
        if (sequence[i] > root) break;
        i++;
    }
    int j = i;
    while (j < hi){
        if (sequence[j] < root) return false;
        j++;
    }
    boolean left = true;
    if (i < hi){
        left = helper(sequence,lo,j-1,j-i);
    }
    boolean right = true;
    if(j < hi){
        right = helper(sequence,j,hi,length-i-1);
    }
    return (left && right);
}
```