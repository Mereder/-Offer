public class GetNumberOfK_fromSortArray {
    public int GetNumberOfK(int [] array , int k) {
        int left = getFirstK(array,k,0,array.length-1);
        int right = getLastK(array,k,0,array.length-1);
        if (left == -1 || right == -1) return 0;
        return right-left+1;
    }

    public int getFirstK(int[] array,int k ,int lo,int hi){
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (array[mid] >= k){
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        if (lo < array.length && array[lo] == k )
            return lo;
        return -1;
    }

    public int getLastK(int[] arrray,int k,int lo,int hi){
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (arrray[mid] > k){
                hi = mid - 1 ;
            }
            // array[mid] <= k
            else {
                lo = mid + 1;
            }
        }
        if (hi >=0 && arrray[hi] == k){
            return hi;
        }
        return -1;
    }
}
