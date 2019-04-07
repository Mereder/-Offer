public class minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if (n <= 0 ) return 0;
        int left = 0;
        int right = n-1;
        int mid = left;
        //  left >= right 才循环，否则直接返回
        while(array[left] >= array[right]){
            // 二分查找结束条件
            if (right - left == 1){
                mid = right;
                break;
            }
            // 这种 二分写法  可以防止 （left+right）/2 越界
            mid = left + (right - left) / 2;
            // 特殊情况 left == mid == right 只能顺序查找
            if (array[left] == array[right] && array[left] == array[mid]){
                // sequence search
                return SequenceSearch(array,left,right);
            }
            // mid 在左侧数列
            if (array[left] <= array[mid] ){
                left = mid;
            }
            // mid 在右侧数列
            else if(array[right] >= array[mid] ){
                right = mid;
            }
        }
        return array[mid];
    }
    public int SequenceSearch(int []array,int low,int high){
        int result = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            if(array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }
}
