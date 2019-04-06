## 题目描述

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

（对应Leetcode  240. Search a 2D Matrix II）

## 解题思路

首先选取数组中==右上角==的数字。

如果该数字等于要查找的数字，查找过程结束；

如果该数字大于要查找的数字，剔除这个数字所在的列；

如果该数字小于要查找的数字，剔除这个数字所在的行。

也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。



关键点： 从右上角开始！！！ 

注意点：

鲁棒性：对于输入的数组是空的，是null的处理。

循环结束条件： 行数超过n-1  或者  列数  < 0 

```java
    public boolean Find(int target, int [][] array) {
        int n = array.length;
        boolean isFind = false;
        if (array != null && n > 0) {
            int row = 0;
            int col = n - 1;
            while (row < n && col >= 0) {
                int A = array[row][col];
                if (target > A) {
                    row++;
                } else if (target < A) {
                    col--;
                } else {
                    isFind = true;
                    break;
                }
            }
        }
        return isFind;
    }
```

