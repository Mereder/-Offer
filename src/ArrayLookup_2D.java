public class ArrayLookup_2D {
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
    //  学习下 单元测试
}
